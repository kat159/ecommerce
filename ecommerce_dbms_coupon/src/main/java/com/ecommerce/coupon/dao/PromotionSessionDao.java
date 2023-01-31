package com.ecommerce.coupon.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.coupon.entity.PromotionSessionEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface PromotionSessionDao extends BaseDao<PromotionSessionEntity> {
	
}