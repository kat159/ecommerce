package com.ecommerce.product.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.product.entity.CategoryEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface CategoryDao extends BaseDao<CategoryEntity> {
	
}