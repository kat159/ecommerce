package com.ecommerce.product.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.product.entity.ProductEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface ProductDao extends BaseDao<ProductEntity> {

    @Select("select * from product where brand_id = #{brandId}")
    List<ProductEntity> selectByBrandId(Long brandId);
	
}