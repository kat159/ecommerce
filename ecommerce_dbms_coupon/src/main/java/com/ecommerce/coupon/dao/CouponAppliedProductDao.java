package com.ecommerce.coupon.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.coupon.entity.CouponAppliedProductEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface CouponAppliedProductDao extends BaseDao<CouponAppliedProductEntity> {
	
}