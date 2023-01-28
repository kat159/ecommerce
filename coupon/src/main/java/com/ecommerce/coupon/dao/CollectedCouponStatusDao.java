package com.ecommerce.coupon.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.coupon.entity.CollectedCouponStatusEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface CollectedCouponStatusDao extends BaseDao<CollectedCouponStatusEntity> {
	
}