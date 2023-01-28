package com.ecommerce.product.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.product.entity.SkuAttrValueEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface SkuAttrValueDao extends BaseDao<SkuAttrValueEntity> {
	
}