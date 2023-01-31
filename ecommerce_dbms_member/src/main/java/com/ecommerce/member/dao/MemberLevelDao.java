package com.ecommerce.member.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.member.entity.MemberLevelEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberLevelDao extends BaseDao<MemberLevelEntity> {
	
}