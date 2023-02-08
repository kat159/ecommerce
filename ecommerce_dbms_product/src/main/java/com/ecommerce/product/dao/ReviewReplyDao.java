package com.ecommerce.product.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.product.entity.ReviewReplyEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ReviewReplyDao extends BaseDao<ReviewReplyEntity> {
	
}