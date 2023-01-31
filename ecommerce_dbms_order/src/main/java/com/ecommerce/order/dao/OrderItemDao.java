package com.ecommerce.order.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.order.entity.OrderItemEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface OrderItemDao extends BaseDao<OrderItemEntity> {
	
}