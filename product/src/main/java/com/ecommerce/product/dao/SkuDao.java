package com.ecommerce.product.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.product.entity.SkuEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface SkuDao extends BaseDao<SkuEntity> {
	
}