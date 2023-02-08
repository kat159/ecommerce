package com.ecommerce.product.service.impl;

import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.product.dao.ProductReviewDao;
import com.ecommerce.product.dto.ProductReviewDto;
import com.ecommerce.product.entity.ProductReviewEntity;
import com.ecommerce.product.service.ProductReviewService;
import com.ecommerce.product.vo.ProductReviewVo;
import org.springframework.stereotype.Service;


@Service
public class ProductReviewServiceImpl
        extends CrudServiceImpl<ProductReviewDao, ProductReviewEntity, ProductReviewDto, ProductReviewVo>
        implements ProductReviewService {

}