package com.ecommerce.product.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.product.entity.CategoryBrandEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface CategoryBrandDao extends BaseDao<CategoryBrandEntity> {
	
}