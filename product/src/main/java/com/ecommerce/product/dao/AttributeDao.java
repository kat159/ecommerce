package com.ecommerce.product.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.product.entity.AttributeEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface AttributeDao extends BaseDao<AttributeEntity> {
	
}