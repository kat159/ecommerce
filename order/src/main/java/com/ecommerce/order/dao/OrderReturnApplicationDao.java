package com.ecommerce.order.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.order.entity.OrderReturnApplicationEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface OrderReturnApplicationDao extends BaseDao<OrderReturnApplicationEntity> {
	
}