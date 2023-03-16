package com.common.country.dao;

import com.ecommerce.common.dao.BaseDao;
import com.common.country.entity.StatesEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface StatesDao extends BaseDao<StatesEntity> {
	
}