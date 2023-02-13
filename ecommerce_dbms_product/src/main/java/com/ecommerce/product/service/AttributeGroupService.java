package com.ecommerce.product.service;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.service.CrudService;
import com.ecommerce.product.dto.AttributeDto;
import com.ecommerce.product.dto.AttributeGroupDto;
import com.ecommerce.product.entity.AttributeGroupEntity;
import com.ecommerce.product.vo.AttributeGroupVo;
import com.ecommerce.product.vo.AttributeVo;

import java.util.List;


public interface AttributeGroupService extends CrudService<AttributeGroupEntity, AttributeGroupDto, AttributeGroupVo> {

    /** Relational: MANY TO ONE <Category> */
    PageData<AttributeGroupVo> pageByCategoryId(Long categoryId, PaginationDto paginationDto);
    List<AttributeGroupVo> getAllByCategoryId(Long categoryId, PaginationDto paginationDto);

    /** Relational: ONE TO MANY <Attribute> */
    List<AttributeVo> getAllAttribute(Long id, PaginationDto paginationDto);

    List<Long> addAllAttribute(Long id, List<AttributeDto> dtoList);
}