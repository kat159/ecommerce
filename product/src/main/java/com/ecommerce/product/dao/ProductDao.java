package com.ecommerce.product.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.product.entity.ProductEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ProductDao extends BaseDao<ProductEntity> {
	
}