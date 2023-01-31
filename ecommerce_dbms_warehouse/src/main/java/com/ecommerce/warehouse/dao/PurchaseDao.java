package com.ecommerce.warehouse.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.warehouse.entity.PurchaseEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface PurchaseDao extends BaseDao<PurchaseEntity> {
	
}