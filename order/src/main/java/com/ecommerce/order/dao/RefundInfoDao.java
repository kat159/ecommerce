package com.ecommerce.order.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.order.entity.RefundInfoEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface RefundInfoDao extends BaseDao<RefundInfoEntity> {
	
}