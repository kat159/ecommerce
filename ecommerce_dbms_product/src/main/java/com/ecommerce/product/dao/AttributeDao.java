package com.ecommerce.product.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.product.entity.AttributeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface AttributeDao extends BaseDao<AttributeEntity> {

    @Select("SELECT * FROM attribute WHERE attribute_group_id = #{id}")
    List<AttributeEntity> selectByAttrGroupId(Long id);
}