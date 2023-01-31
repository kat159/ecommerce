package com.ecommerce.product.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.product.entity.BrandEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface BrandDao extends BaseDao<BrandEntity> {
	
}