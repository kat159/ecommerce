package com.ecommerce.product.service.impl;

import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.common.utils.ConvertUtils;
import com.ecommerce.product.dao.SkuDao;
import com.ecommerce.product.dao.SkuSkuImageDao;
import com.ecommerce.product.dto.SkuDto;
import com.ecommerce.product.entity.SkuEntity;
import com.ecommerce.product.entity.SkuSkuImageEntity;
import com.ecommerce.product.service.SkuAttributeValueService;
import com.ecommerce.product.service.SkuService;
import com.ecommerce.product.service.SkuSkuImageService;
import com.ecommerce.product.vo.SkuSkuImageVo;
import com.ecommerce.product.vo.SkuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class SkuServiceImpl
        extends CrudServiceImpl<SkuDao, SkuEntity, SkuDto, SkuVo>
        implements SkuService {

    @Autowired
    private SkuDao skuDao;
    @Autowired
    private SkuSkuImageService skuSkuImageService;
    @Autowired
    private SkuAttributeValueService skuAttributeValueService;
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
}