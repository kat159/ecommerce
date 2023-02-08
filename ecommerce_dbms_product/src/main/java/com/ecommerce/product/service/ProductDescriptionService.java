package com.ecommerce.product.service;

import com.ecommerce.common.service.CrudService;
import com.ecommerce.product.dto.ProductDescriptionDto;
import com.ecommerce.product.entity.ProductDescriptionEntity;
import com.ecommerce.product.vo.ProductDescriptionVo;


public interface ProductDescriptionService extends CrudService<ProductDescriptionEntity, ProductDescriptionDto, ProductDescriptionVo> {

}