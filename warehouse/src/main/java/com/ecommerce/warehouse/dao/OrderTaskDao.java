package com.ecommerce.warehouse.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.warehouse.entity.OrderTaskEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface OrderTaskDao extends BaseDao<OrderTaskEntity> {
	
}