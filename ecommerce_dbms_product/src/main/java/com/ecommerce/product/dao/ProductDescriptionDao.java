package com.ecommerce.product.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.product.entity.ProductDescriptionEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ProductDescriptionDao extends BaseDao<ProductDescriptionEntity> {
	
}