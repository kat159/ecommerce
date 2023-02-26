package com.ecommerce.product.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.common.utils.Query;
import com.ecommerce.product.entity.BrandEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.stream.Collectors;


@Mapper
public interface BrandDao extends BaseDao<BrandEntity> {

    default List<String> selectNameByIdList(List<Long> brandIdList) {
        QueryWrapper<BrandEntity> wrapper = new QueryWrapper<>();
        wrapper.in("id", brandIdList);
        wrapper.eq("non_deleted", 1).or().isNull("non_deleted");
        wrapper.select("name");
        return selectList(wrapper).stream().map(BrandEntity::getName).collect(Collectors.toList());
    }
}