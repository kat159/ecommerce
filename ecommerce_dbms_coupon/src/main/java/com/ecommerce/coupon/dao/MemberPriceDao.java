package com.ecommerce.coupon.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.coupon.entity.MemberPriceEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberPriceDao extends BaseDao<MemberPriceEntity> {
	
}