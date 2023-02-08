package com.ecommerce.product.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.product.entity.ProductImageEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ProductImageDao extends BaseDao<ProductImageEntity> {
	
}