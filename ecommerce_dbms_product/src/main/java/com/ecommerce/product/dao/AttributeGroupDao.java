package com.ecommerce.product.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.product.entity.AttributeGroupEntity;
import com.ecommerce.product.vo.AttributeGroupVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface AttributeGroupDao extends BaseDao<AttributeGroupEntity> {

    @Select("SELECT * FROM attribute_group WHERE category_id = #{categoryId} ORDER BY sort ASC")
    List<AttributeGroupEntity> selectByCategoryId(Long categoryId);


}