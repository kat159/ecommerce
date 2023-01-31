package com.ecommerce.coupon.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.coupon.entity.ProductRewardEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ProductRewardDao extends BaseDao<ProductRewardEntity> {
	
}