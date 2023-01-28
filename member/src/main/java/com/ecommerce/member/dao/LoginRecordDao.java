package com.ecommerce.member.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.member.entity.LoginRecordEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface LoginRecordDao extends BaseDao<LoginRecordEntity> {
	
}