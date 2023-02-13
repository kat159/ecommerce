package com.ecommerce.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.product.dao.AttributeGroupDao;
import com.ecommerce.product.dto.AttributeDto;
import com.ecommerce.product.dto.AttributeGroupDto;
import com.ecommerce.product.entity.AttributeGroupEntity;
import com.ecommerce.product.service.AttributeGroupService;
import com.ecommerce.product.service.AttributeService;
import com.ecommerce.product.vo.AttributeGroupVo;
import com.ecommerce.product.vo.AttributeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AttributeGroupServiceImpl
        extends CrudServiceImpl<AttributeGroupDao, AttributeGroupEntity, AttributeGroupDto, AttributeGroupVo>
        implements AttributeGroupService {
    @Autowired
    AttributeService attributeService;


    /**
     * Relational: Many to One Category
     */
    @Override
    public PageData<AttributeGroupVo> pageByCategoryId(Long categoryId, PaginationDto paginationDto) {
        QueryWrapper<AttributeGroupEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category_id", categoryId);
        queryWrapper.orderByAsc("sort");
        return page(paginationDto, queryWrapper);
    }

    @Override
    public List<AttributeGroupVo> getAllByCategoryId(Long categoryId, PaginationDto paginationDto) {
        QueryWrapper<AttributeGroupEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category_id", categoryId);
        queryWrapper.orderByAsc("sort");
        return getAll(queryWrapper);
    }

    /**
     * Relational: One to Many Attribute
     */
    @Override
    public List<AttributeVo> getAllAttribute(Long id, PaginationDto paginationDto) {
        return attributeService.getAllByAttributeGroupId(id, paginationDto);
    }

    @Override
    public List<Long> addAllAttribute(Long id, List<AttributeDto> dtoList) {
        dtoList.forEach(dto -> dto.setAttributeGroupId(id));
        return attributeService.addAll(dtoList);
    }
}