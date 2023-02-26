package com.ecommerce.product.service;

import com.ecommerce.common.service.CrudService;
import com.ecommerce.product.dto.SkuImageDto;
import com.ecommerce.product.entity.SkuImageEntity;
import com.ecommerce.product.vo.SkuImageVo;
import com.ecommerce.product.vo.SkuSkuImageVo;

import java.util.List;


public interface SkuImageService extends CrudService<SkuImageEntity, SkuImageDto, SkuImageVo> {

    @Override
    void removeAll(List<Long> ids);

    List<SkuImageVo> getAllBySkuId(Long id);

    void removeAllByProductId(List<Long> ids);
}