package com.ecommerce.coupon.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.coupon.entity.PromotionEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface PromotionDao extends BaseDao<PromotionEntity> {
	
}