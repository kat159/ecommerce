package com.common.country.dao;

import com.ecommerce.common.dao.BaseDao;
import com.common.country.entity.CitiesEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface CitiesDao extends BaseDao<CitiesEntity> {
	
}