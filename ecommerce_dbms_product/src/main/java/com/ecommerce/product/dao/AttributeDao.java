package com.ecommerce.product.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.product.entity.AttributeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Mapper
public interface AttributeDao extends BaseDao<AttributeEntity> {

    @Select("SELECT * FROM attribute WHERE attribute_group_id = #{id}")
    List<AttributeEntity> selectByAttrGroupId(Long id);

    default List<Long> selectIdListByAttributeGroupId(List<Long> idList) {
        if (idList == null || idList.isEmpty()) {
            return new ArrayList<>();
        }
        QueryWrapper<AttributeEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("attribute_group_id", idList);
        queryWrapper.select("id");
        List<AttributeEntity> attributeEntities = selectList(queryWrapper);
        return attributeEntities == null ? new ArrayList<>()
                : attributeEntities.stream().map(AttributeEntity::getId).collect(Collectors.toList());
    }
}