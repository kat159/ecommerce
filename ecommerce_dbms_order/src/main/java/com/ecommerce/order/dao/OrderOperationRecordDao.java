package com.ecommerce.order.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.order.entity.OrderOperationRecordEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface OrderOperationRecordDao extends BaseDao<OrderOperationRecordEntity> {
	
}