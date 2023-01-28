package com.ecommerce.member.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.member.entity.StatisticsEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface StatisticsDao extends BaseDao<StatisticsEntity> {
	
}