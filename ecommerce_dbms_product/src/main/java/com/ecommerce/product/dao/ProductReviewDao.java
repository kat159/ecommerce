package com.ecommerce.product.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.product.entity.ProductReviewEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ProductReviewDao extends BaseDao<ProductReviewEntity> {
	
}