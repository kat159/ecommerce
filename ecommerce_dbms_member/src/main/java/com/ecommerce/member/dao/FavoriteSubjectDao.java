package com.ecommerce.member.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.member.entity.FavoriteSubjectEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface FavoriteSubjectDao extends BaseDao<FavoriteSubjectEntity> {
	
}