package com.ecommerce.warehouse.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.warehouse.entity.SkuInventoryEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface SkuInventoryDao extends BaseDao<SkuInventoryEntity> {
	
}