package com.ecommerce.member.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.member.entity.MemberEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberDao extends BaseDao<MemberEntity> {
	
}