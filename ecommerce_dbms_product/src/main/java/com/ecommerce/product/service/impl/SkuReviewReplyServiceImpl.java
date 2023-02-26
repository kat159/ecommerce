package com.ecommerce.product.service.impl;

import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.product.dao.SkuReviewReplyDao;
import com.ecommerce.product.dto.SkuReviewReplyDto;
import com.ecommerce.product.entity.SkuReviewReplyEntity;
import com.ecommerce.product.service.SkuReviewReplyService;
import com.ecommerce.product.vo.SkuReviewReplyVo;
import org.springframework.stereotype.Service;


@Service
public class SkuReviewReplyServiceImpl
        extends CrudServiceImpl<SkuReviewReplyDao, SkuReviewReplyEntity, SkuReviewReplyDto, SkuReviewReplyVo>
        implements SkuReviewReplyService {

}