package com.ecommerce.product.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.product.entity.CategoryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface CategoryDao extends BaseDao<CategoryEntity> {
	@Select("SELECT * FROM category WHERE parent_id = #{parentId} AND non_deleted = 1")
	List<CategoryEntity> selectByParentId(Long parentId);
}