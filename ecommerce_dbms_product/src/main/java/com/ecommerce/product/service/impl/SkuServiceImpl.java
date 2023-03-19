package com.ecommerce.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.dto.internal_dto.OrderSkuInternalDto;
import com.ecommerce.common.dto.internal_dto.SkuReviewInternalDto;
import com.ecommerce.common.exception.ErrorCodeEnum;
import com.ecommerce.common.exception.MyBusinessException;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.common.utils.ConvertUtils;
import com.ecommerce.common.utils.Result;
import com.ecommerce.product.dao.SkuDao;
import com.ecommerce.product.dto.SkuDto;
import com.ecommerce.product.entity.SkuEntity;
import com.ecommerce.product.entity.StockDeductionOfConfirmedOrder;
import com.ecommerce.product.entity.StockDeductionOfUnconfirmedOrder;
import com.ecommerce.product.entity.StockDeductionRollback;
import com.ecommerce.product.open_feign.OrderClient;
import com.ecommerce.product.repository.StockDeductionOfConfirmedOrderDao;
import com.ecommerce.product.repository.StockDeductionOfUnconfirmedOrderDao;
import com.ecommerce.product.repository.StockDeductionRollbackDao;
import com.ecommerce.product.service.*;
import com.ecommerce.product.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@Slf4j
public class SkuServiceImpl
        extends CrudServiceImpl<SkuDao, SkuEntity, SkuDto, SkuVo>
        implements SkuService {

    @Autowired
    private SkuDao skuDao;
    @Autowired
    private SkuSkuImageService skuSkuImageService;
    @Autowired
    private SkuAttributeValueService skuAttributeValueService;
    @Autowired
    private SkuImageService skuImageService;
    @Autowired
    private AttributeService attributeService;
    @Autowired
    private StockDeductionRollbackDao stockDeductionRollbackDao;
    @Autowired
    private StockDeductionOfConfirmedOrderDao stockDeductionOfConfirmedOrderDao;
    @Autowired
    private StockDeductionOfUnconfirmedOrderDao stockDeductionOfUnconfirmedOrderDao;
    @Autowired
    private OrderClient orderClient;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deductInventory(List<OrderSkuInternalDto> orderSkuList) {
        for (OrderSkuInternalDto orderSku : orderSkuList) {
            if (orderSku.getSkuId() == null) {
                throw new RuntimeException("skuId is null");
            }
            if (orderSku.getQuantity() == null || orderSku.getQuantity() <= 0) {
                throw new RuntimeException("quantity is null or <= 0");
            }
        }
        for (OrderSkuInternalDto orderSku : orderSkuList) {
            if (skuDao.deductInventory(orderSku.getSkuId(), orderSku.getQuantity()) != 1) {
                throw new MyBusinessException(ErrorCodeEnum.STOCK_NOT_ENOUGH);
            }
        }
        List<StockDeductionOfUnconfirmedOrder> list = ConvertUtils.sourceToTarget(orderSkuList, StockDeductionOfUnconfirmedOrder.class);
        stockDeductionOfUnconfirmedOrderDao.saveAll(list);
    }

    @Override
    public void review(SkuReviewInternalDto skuReviewInternalDto) {
        Long skuId = skuReviewInternalDto.getSkuId();
        BigDecimal rating = skuReviewInternalDto.getRating();
        if (skuId == null || rating == null) {
            throw new RuntimeException("skuId is null or rating is null");
        }
        SkuEntity skuEntity = baseDao.selectById(skuId);
        if (skuEntity == null) {
            throw new RuntimeException("skuId is not exist");
        }
        Long ratingCount = skuEntity.getRatingCount();
        BigDecimal ratingSum = skuEntity.getRating();
        if (ratingCount == null) {
            ratingCount = 0L;
        }
        if (ratingSum == null) {
            ratingSum = BigDecimal.ZERO;
        }
        ratingCount++;
        ratingSum = ratingSum.add(rating);
        BigDecimal newRating = ratingSum.divide(new BigDecimal(ratingCount), 1, RoundingMode.HALF_UP);
        skuEntity.setRatingCount(ratingCount);
        skuEntity.setRating(newRating);
        baseDao.updateById(skuEntity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void confirmInventoryDeduction(String orderUUID) {
        // receive orderUUID of confirmed created order from MQ, confirm the inventory deduction
        List<StockDeductionOfUnconfirmedOrder> list = stockDeductionOfUnconfirmedOrderDao.findAllByOrderUUID(orderUUID);
        if (list == null || list.size() == 0) {
            log.error("No stock deduction record found for orderUUID: {}", orderUUID);
            return;
        }
        System.out.println("confirm deduction list: " + list);
        List<StockDeductionOfConfirmedOrder> list2 = new ArrayList<>();
        for (StockDeductionOfUnconfirmedOrder stockDeductionOfUnconfirmedOrder : list) {
            StockDeductionOfConfirmedOrder stockDeductionOfConfirmedOrder = new StockDeductionOfConfirmedOrder();
            stockDeductionOfConfirmedOrder.setSkuId(stockDeductionOfUnconfirmedOrder.getSkuId());
            stockDeductionOfConfirmedOrder.setQuantity(stockDeductionOfUnconfirmedOrder.getQuantity());
            stockDeductionOfConfirmedOrder.setOrderUUID(orderUUID);
            list2.add(stockDeductionOfConfirmedOrder);
        }
        System.out.println("confirm deduction list2: " + list2);
        stockDeductionOfConfirmedOrderDao.saveAll(list2);
        stockDeductionOfUnconfirmedOrderDao.deleteAllByOrderUUID(orderUUID);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void scanAndRollbackInventoryDeduction() {
        LocalDateTime curTime = LocalDateTime.now();
        long total = stockDeductionOfUnconfirmedOrderDao.count();
        while (total-- > 0) {
            StockDeductionOfUnconfirmedOrder stockDeductionOfUnconfirmedOrder = stockDeductionOfUnconfirmedOrderDao.findFirstByOrderByIdAsc();
            if (stockDeductionOfUnconfirmedOrder == null) {
                break;
            }
            LocalDateTime createTime = stockDeductionOfUnconfirmedOrder.getCreateDate();
            long timeDifference = Duration.between(createTime, curTime).toMillis();

            // if create_date - cur_date < 10min return,
            if (timeDifference < 10 * 60 * 1000) {
                return;
            }

            String orderUUID = stockDeductionOfUnconfirmedOrder.getOrderUUID();

            Result<Object> res = null;
            // get order by orderUUID from order service
            int maxAttempts = 5;
            for (int attempt = 0; attempt < maxAttempts; attempt++) {
                try {
                    res = orderClient.getOrderByOrderUUID(orderUUID);
                    break;
                } catch (Exception e) {
                    log.warn("Attempt {} to get order failed: {}", attempt + 1, e.getMessage());
                }
            }
            if (res == null) {
                log.error("Failed to get order from order service after {} attempts", maxAttempts);
                return;
            }
            List<StockDeductionOfUnconfirmedOrder> unconfirmedDeductionList = stockDeductionOfUnconfirmedOrderDao.findAllByOrderUUID(orderUUID);
            if (res.getData() == null) {
                // if order not found in order service database, rollback deduction
                stockDeductionOfUnconfirmedOrderDao.deleteByOrderUUID(orderUUID);
                skuDao.addInventory(stockDeductionOfUnconfirmedOrder.getSkuId(), stockDeductionOfUnconfirmedOrder.getQuantity());
                List<StockDeductionRollback> rollbacks = ConvertUtils.sourceToTarget(unconfirmedDeductionList, StockDeductionRollback.class);
                stockDeductionRollbackDao.saveAll(rollbacks);
            } else {
                // if order found, wait for MQ Listener to confirm inventory deduction.
                //   MQ listener will receive orderUUID of confirmed created order from order service directly, saving the cost to verify order from order service.
                //   successful order is guaranteed to reach MQ, if order service failed to send message to MQ when creating an order, the transaction will be rolled back
                // TODO: Publisher Confirms + callback to confirm rabbitmq server received the message
                return;
            }
        }
    }
    @Override
    public Long add(SkuDto dto) {
        BigDecimal discount = dto.getPrimeDiscount();
        if (discount == null) {
            discount = new BigDecimal(0);
        }
        BigDecimal hundred = BigDecimal.valueOf(100);
        BigDecimal finalPrice = hundred.subtract(discount).divide(hundred,2, RoundingMode.HALF_UP).multiply(dto.getPrice());
        dto.setFinalPrice(finalPrice);
        Long skuId = super.add(dto);
        return skuId;
    }
    @Override
    public List<Long> addAll(List<SkuDto> dtoList) {
        List<Long> skuIdList = new ArrayList<>();
        for (SkuDto dto : dtoList) {
            Long skuId = add(dto);
            skuIdList.add(skuId);
        }
        return skuIdList;
    }
    @Override
    public void update(SkuDto dto) {
        System.out.println("sku update: " + dto);
        BigDecimal discount = dto.getPrimeDiscount();
        if (discount == null) {
            discount = new BigDecimal(0);
        }
        BigDecimal hundred = BigDecimal.valueOf(100);
        BigDecimal finalPrice = hundred.subtract(discount).divide(hundred,2, RoundingMode.HALF_UP).multiply(dto.getPrice());
        dto.setFinalPrice(finalPrice);
        super.update(dto);
    }
    @Override
    public void updateAll(List<SkuDto> dtoList) {
        for (SkuDto dto : dtoList) {
            update(dto);
        }
    }

    @Override
    public List<SkuVo> getAllByProductId(Long id) {
        List<SkuVo> skuVoList = ConvertUtils.sourceToTarget(skuDao.getAllByProductId(id), SkuVo.class);
        return skuVoList == null ? new ArrayList<>() : skuVoList;
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeAll(List<Long> idList) {
        if (idList == null || idList.size() == 0) {
            return;
        }
        // 1. delete sku
        baseDao.deleteBatchIds(idList);
        // 2. delete sku_sku_image
        skuSkuImageService.removeAllBySkuIdList(idList);
        // 3. delete sku_attribute_value
        skuAttributeValueService.removeAllBySkuIdList(idList);
        // 4. keep sku_reviews
    }
    @Override
    // @Transactional(rollbackFor = Exception.class)
    public void removeAllByProductId(List<Long> productIds) {
        if (productIds == null || productIds.size() == 0) {
            return;
        }
        List<Long> skuIds = skuDao.getAllSkuIdsByProductIdList(productIds);
        if (skuIds == null || skuIds.size() == 0) {
            return;
        }
        removeAll(skuIds);
        // // 1. delete sku
        // baseDao.deleteBatchIds(skuIds);
        // // 2. delete sku_sku_image
        // skuSkuImageService.removeAllBySkuIdList(skuIds);
        // // 3. delete sku_attribute_value
        // skuAttributeValueService.removeAllBySkuIdList(skuIds);
        // // 4. keep sku_reviews
    }

    @Override
    public List<SkuVo> getAll(PaginationDto params) {
        QueryWrapper<SkuEntity> queryWrapper = new QueryWrapper<>();
        if (params.getIds() != null && params.getIds().size() > 0) {
            queryWrapper.in("id", params.getIds());
        }
        List<SkuVo> skuVoList = ConvertUtils.sourceToTarget(baseDao.selectList(queryWrapper), SkuVo.class);
        System.out.println("skuVoList = " + skuVoList);
        // get sku images && sale attributes
        for (SkuVo skuVo : skuVoList) {
            List<SkuImageVo> skuImageVoList = skuImageService.getAllBySkuId(skuVo.getId());
            skuVo.setSkuImages(skuImageVoList);
            List<SkuAttributeValueVo> skuAttributeValueVoList = skuAttributeValueService.getAllBySkuId(skuVo.getId());
            for (SkuAttributeValueVo skuAttributeValueVo : skuAttributeValueVoList) {
                AttributeVo attributeVo = attributeService.get(skuAttributeValueVo.getAttributeId());
                skuAttributeValueVo.setAttributeName(attributeVo.getName());
            }
            skuVo.setSaleAttrValues(skuAttributeValueVoList);
        }
        return skuVoList == null ? new ArrayList<>() : skuVoList;
    }
}