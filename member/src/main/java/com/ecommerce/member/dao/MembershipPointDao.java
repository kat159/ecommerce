package com.ecommerce.member.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.member.entity.MembershipPointEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MembershipPointDao extends BaseDao<MembershipPointEntity> {
	
}