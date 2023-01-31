package com.ecommerce.order.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.order.entity.OrderSettingEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface OrderSettingDao extends BaseDao<OrderSettingEntity> {
	
}