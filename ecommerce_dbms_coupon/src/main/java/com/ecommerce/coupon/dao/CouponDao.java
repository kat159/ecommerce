package com.ecommerce.coupon.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.coupon.entity.CouponEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface CouponDao extends BaseDao<CouponEntity> {
	
}