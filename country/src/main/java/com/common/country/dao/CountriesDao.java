package com.common.country.dao;

import com.ecommerce.common.dao.BaseDao;
import com.common.country.entity.CountriesEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface CountriesDao extends BaseDao<CountriesEntity> {
	
}