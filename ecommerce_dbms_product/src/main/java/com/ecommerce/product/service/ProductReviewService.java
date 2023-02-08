package com.ecommerce.product.service;

import com.ecommerce.common.service.CrudService;
import com.ecommerce.product.dto.ProductReviewDto;
import com.ecommerce.product.entity.ProductReviewEntity;
import com.ecommerce.product.vo.ProductReviewVo;


public interface ProductReviewService extends CrudService<ProductReviewEntity, ProductReviewDto, ProductReviewVo> {

}