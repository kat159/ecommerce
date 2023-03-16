package com.ecommerce.member.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.member.entity.MembershipTypeEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MembershipTypeDao extends BaseDao<MembershipTypeEntity> {
	
}