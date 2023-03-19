package com.ecommerce.product.service;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.service.CrudService;
import com.ecommerce.product.dto.AttributeGroupDto;
import com.ecommerce.product.dto.CategoryDto;
import com.ecommerce.product.dto.aggregate.CategoryManageDto;
import com.ecommerce.product.dto.pagination.CategoryPaginationDto;
import com.ecommerce.product.entity.CategoryEntity;
import com.ecommerce.product.vo.AttributeGroupVo;
import com.ecommerce.product.vo.CategoryTreeVo;
import com.ecommerce.product.vo.CategoryVo;
import com.ecommerce.product.vo.aggregate.CategoryManageVo;
import com.ecommerce.product.vo.category.AttrGroupWithAttrVo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface CategoryService extends CrudService<CategoryEntity, CategoryDto, CategoryVo> {

    @Override
    List<Long> addAll(List<CategoryDto> dtoList);
    @Override
    void removeAll(List<Long> idList);
    List<CategoryTreeVo> getForest();
    List<CategoryVo> getAll(CategoryPaginationDto paginationDto);
    /** Relational: <AttributeGroup> */
    PageData<AttributeGroupVo> pageAttrGroups(Long categoryId, PaginationDto paginationDto);
    List<AttributeGroupVo> getAllAttrGroups(Long categoryId, PaginationDto paginationDto);
    List<Long> addAllAttrGroup(Long categoryId, List<AttributeGroupDto> attributeGroupDtoList);

    List<AttrGroupWithAttrVo> getAllAttrGroupWithAttrList(Long categoryId);

    List<CategoryManageVo> getForestV2();

    void updateAllV2(CategoryManageDto dto);
}