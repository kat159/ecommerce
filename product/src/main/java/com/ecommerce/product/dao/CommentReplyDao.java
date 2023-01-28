package com.ecommerce.product.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.product.entity.CommentReplyEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface CommentReplyDao extends BaseDao<CommentReplyEntity> {
	
}