package com.ecommerce.product.service.impl;

import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.product.dao.SkuReviewDao;
import com.ecommerce.product.dto.SkuReviewDto;
import com.ecommerce.product.entity.SkuReviewEntity;
import com.ecommerce.product.service.SkuReviewService;
import com.ecommerce.product.vo.SkuReviewVo;
import org.springframework.stereotype.Service;


@Service
public class SkuReviewServiceImpl
        extends CrudServiceImpl<SkuReviewDao, SkuReviewEntity, SkuReviewDto, SkuReviewVo>
        implements SkuReviewService {

}