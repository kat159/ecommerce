package com.ecommerce.product.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.product.dto.pagination.AttrFilter;
import com.ecommerce.product.dto.pagination.ProductSearchParams;
import com.ecommerce.product.entity.ProductEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface ProductDao extends BaseDao<ProductEntity> {

    @Select("SELECT * FROM product WHERE brand_id = #{brandId}")
    List<ProductEntity> selectByBrandId(Long brandId);

    @Select("SELECT * FROM product WHERE name = #{name}")
    List<ProductEntity> selectByName(String name);

    @Select("SELECT * FROM product WHERE name LIKE CONCAT(#{namePrefix}, '%')")
    List<ProductEntity> selectByNamePrefix(String namePrefix);

    @Select("SELECT * FROM product WHERE name LIKE CONCAT('%', #{nameSubstring}, '%')")
    List<ProductEntity> selectByNameSubstring(String nameSubstring);
    @Select("SELECT * FROM product WHERE category_id = #{categoryId}")
    List<ProductEntity> selectByCategoryId(Long categoryId);

    @Select("SELECT id FROM product WHERE category_id = #{categoryId}")
    List<Long> selectProductIdsByCategoryId(Long categoryId);

}