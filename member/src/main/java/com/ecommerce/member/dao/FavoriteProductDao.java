package com.ecommerce.member.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.member.entity.FavoriteProductEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface FavoriteProductDao extends BaseDao<FavoriteProductEntity> {
	
}