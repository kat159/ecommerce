package com.ecommerce.product.service;

import com.ecommerce.common.service.CrudService;
import com.ecommerce.product.dto.ProductDto;
import com.ecommerce.product.entity.ProductEntity;


public interface ProductService extends CrudService<ProductEntity, ProductDto> {

}