package com.ecommerce.order.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.order.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface OrderDao extends BaseDao<OrderEntity> {
	
}