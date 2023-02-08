package com.ecommerce.product.service.impl;

import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.product.dao.ReviewReplyDao;
import com.ecommerce.product.dto.ReviewReplyDto;
import com.ecommerce.product.entity.ReviewReplyEntity;
import com.ecommerce.product.service.ReviewReplyService;
import com.ecommerce.product.vo.ReviewReplyVo;
import org.springframework.stereotype.Service;


@Service
public class ReviewReplyServiceImpl
        extends CrudServiceImpl<ReviewReplyDao, ReviewReplyEntity, ReviewReplyDto, ReviewReplyVo>
        implements ReviewReplyService {

}