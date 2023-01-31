package com.ecommerce.warehouse.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.warehouse.entity.PurchaseDetailEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface PurchaseDetailDao extends BaseDao<PurchaseDetailEntity> {
	
}