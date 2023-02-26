package com.ecommerce.product.service;

import com.ecommerce.common.service.CrudService;
import com.ecommerce.product.dto.SkuAttributeValueDto;
import com.ecommerce.product.entity.SkuAttributeValueEntity;
import com.ecommerce.product.vo.SkuAttributeValueVo;

import java.util.List;


public interface SkuAttributeValueService extends CrudService<SkuAttributeValueEntity, SkuAttributeValueDto, SkuAttributeValueVo> {

    List<SkuAttributeValueVo> getAllBySkuId(Long id);

    void removeAllBySkuIdList(List<Long> skuIds);

    void removeAllByAttributeId(List<Long> idList);
}