package com.ecommerce.member.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.member.entity.ReceivingAddressEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ReceivingAddressDao extends BaseDao<ReceivingAddressEntity> {
	
}