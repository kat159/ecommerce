package com.ecommerce.product.service;

import com.ecommerce.common.service.CrudService;
import com.ecommerce.product.dto.SkuSkuImageDto;
import com.ecommerce.product.entity.SkuSkuImageEntity;
import com.ecommerce.product.vo.SkuSkuImageVo;

import java.util.List;


public interface SkuSkuImageService extends CrudService<SkuSkuImageEntity, SkuSkuImageDto, SkuSkuImageVo> {

    List<SkuSkuImageVo> getAllBySkuId(Long id);

    void removeAllBySkuImageIds(List<Long> skuImageIds);

    void removeAllBySkuIdList(List<Long> skuIds);
}