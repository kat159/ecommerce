package com.ecommerce.product.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.product.entity.ProductImagesEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ProductImagesDao extends BaseDao<ProductImagesEntity> {
	
}