package com.ecommerce.product.service;

import com.ecommerce.common.service.CrudService;
import com.ecommerce.product.dto.ProductAttrbuteValueDto;
import com.ecommerce.product.entity.ProductAttrbuteValueEntity;
import com.ecommerce.product.vo.ProductAttrbuteValueVo;

import java.util.List;


public interface ProductAttrbuteValueService extends CrudService<ProductAttrbuteValueEntity, ProductAttrbuteValueDto, ProductAttrbuteValueVo> {

    List<ProductAttrbuteValueVo> getAllByProductId(Long id);

    void removeAllByProductId(List<Long> productIds);

    void removeAllByAttributeId(List<Long> idList);
}