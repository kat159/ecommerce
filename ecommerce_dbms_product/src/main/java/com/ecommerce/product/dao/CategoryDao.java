package com.ecommerce.product.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.product.entity.CategoryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.stream.Collectors;


@Mapper
public interface CategoryDao extends BaseDao<CategoryEntity> {
	@Select("SELECT * FROM category WHERE parent_id = #{parentId} AND non_deleted = 1")
	List<CategoryEntity> selectByParentId(Long parentId);

	// @Select("SELECT name FROM category WHERE id in (#{categoryIdList}) AND non_deleted = 1") // **can not use List as parameter
    default List<String> selectNameByIdList(List<Long> categoryIdList) {
		QueryWrapper<CategoryEntity> wrapper = new QueryWrapper<>();
		wrapper.in("id", categoryIdList);
		wrapper.eq("non_deleted", 1);
		wrapper.select("name");
		return selectList(wrapper).stream().map(CategoryEntity::getName).collect(Collectors.toList());
	}
}