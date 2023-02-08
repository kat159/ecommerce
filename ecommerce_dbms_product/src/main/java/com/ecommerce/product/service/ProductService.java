package com.ecommerce.product.service;

import com.ecommerce.common.service.CrudService;
import com.ecommerce.product.dto.ProductDto;
import com.ecommerce.product.entity.ProductEntity;
import com.ecommerce.product.vo.ProductVo;


public interface ProductService extends CrudService<ProductEntity, ProductDto, ProductVo> {

}