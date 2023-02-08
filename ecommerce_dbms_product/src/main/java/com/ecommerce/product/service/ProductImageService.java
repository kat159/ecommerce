package com.ecommerce.product.service;

import com.ecommerce.common.service.CrudService;
import com.ecommerce.product.dto.ProductImageDto;
import com.ecommerce.product.entity.ProductImageEntity;
import com.ecommerce.product.vo.ProductImageVo;


public interface ProductImageService extends CrudService<ProductImageEntity, ProductImageDto, ProductImageVo> {

}