package com.ecommerce.warehouse.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.warehouse.entity.OrderTaskDetailEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface OrderTaskDetailDao extends BaseDao<OrderTaskDetailEntity> {
	
}