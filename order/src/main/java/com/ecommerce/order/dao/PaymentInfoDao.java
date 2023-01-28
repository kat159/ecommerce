package com.ecommerce.order.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.order.entity.PaymentInfoEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface PaymentInfoDao extends BaseDao<PaymentInfoEntity> {
	
}