package com.ecommerce.product.service;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.dto.internal_dto.OrderSkuInternalDto;
import com.ecommerce.common.dto.internal_dto.SkuReviewInternalDto;
import com.ecommerce.common.service.CrudService;
import com.ecommerce.product.dto.SkuDto;
import com.ecommerce.product.entity.SkuEntity;
import com.ecommerce.product.vo.SkuVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface SkuService extends CrudService<SkuEntity, SkuDto, SkuVo> {

    List<SkuVo> getAllByProductId(Long id);
    @Override
    void removeAll(List<Long> idList);
    void removeAllByProductId(List<Long> productIds);
    List<SkuVo> getAll(PaginationDto params);

    void confirmInventoryDeduction(String orderUUID);
    void scanAndRollbackInventoryDeduction();

    @Override
    Long add(SkuDto dto);
    @Override
    List<Long> addAll(List<SkuDto> dtoList);
    @Override
    void update(SkuDto dto);
    @Override
    void updateAll(List<SkuDto> dtoList);
    void deductInventory(List<OrderSkuInternalDto> orderSkuList);

    void review(SkuReviewInternalDto skuReviewInternalDto);
}