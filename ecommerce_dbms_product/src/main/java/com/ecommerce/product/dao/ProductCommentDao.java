package com.ecommerce.product.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.product.entity.ProductCommentEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ProductCommentDao extends BaseDao<ProductCommentEntity> {
	
}