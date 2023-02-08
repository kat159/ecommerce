package com.ecommerce.product.service;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.service.CrudService;
import com.ecommerce.product.dto.AttributeGroupDto;
import com.ecommerce.product.dto.CategoryDto;
import com.ecommerce.product.entity.CategoryEntity;
import com.ecommerce.product.vo.AttributeGroupVo;
import com.ecommerce.product.vo.CategoryTreeVo;
import com.ecommerce.product.vo.CategoryVo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface CategoryService extends CrudService<CategoryEntity, CategoryDto, CategoryVo> {

    List<Long> addAll(List<CategoryDto> dtoList);
    List<CategoryTreeVo> getForest();

    /** Relational: <AttributeGroup> */
    PageData<AttributeGroupVo> pageAttrGroups(Long categoryId, PaginationDto paginationDto);
    List<AttributeGroupVo> getAllAttrGroups(Long categoryId, PaginationDto paginationDto);
    void addAllAttrGroup(Long categoryId, List<AttributeGroupDto> attributeGroupDtoList);

}