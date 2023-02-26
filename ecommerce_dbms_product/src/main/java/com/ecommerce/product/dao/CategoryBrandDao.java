package com.ecommerce.product.dao;

import com.ecommerce.common.bo.TreeBo;
import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.product.entity.CategoryBrandEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


@Mapper
public interface CategoryBrandDao extends BaseDao<CategoryBrandEntity> {
	@Select("select * from category_brand where category_id = #{categoryId}")
    CategoryBrandEntity selectByCategoryId(Long categoryId);

    @Select("select * from category_brand where brand_id = #{brandId}")
    List<CategoryBrandEntity> selectByBrandId(Long brandId);

    @Select("select * from category_brand where category_id = #{categoryId} and brand_id = #{brandId}")
    List<CategoryBrandEntity> selectByCategoryAndBrand(Long categoryId, Long brandId);
}