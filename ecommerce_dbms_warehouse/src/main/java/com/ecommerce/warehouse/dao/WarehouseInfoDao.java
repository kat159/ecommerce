package com.ecommerce.warehouse.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.warehouse.entity.WarehouseInfoEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface WarehouseInfoDao extends BaseDao<WarehouseInfoEntity> {
	
}