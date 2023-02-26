package com.ecommerce.product.service;

import com.ecommerce.common.service.CrudService;
import com.ecommerce.product.dto.SkuDto;
import com.ecommerce.product.entity.SkuEntity;
import com.ecommerce.product.vo.SkuVo;

import java.util.List;


public interface SkuService extends CrudService<SkuEntity, SkuDto, SkuVo> {

    List<SkuVo> getAllByProductId(Long id);

    @Override
    void removeAll(List<Long> idList);
    void removeAllByProductId(List<Long> productIds);
}