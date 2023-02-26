package com.ecommerce.product.service;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.service.CrudService;
import com.ecommerce.product.dto.AttributeDto;
import com.ecommerce.product.entity.AttributeEntity;
import com.ecommerce.product.vo.AttributeVo;

import java.util.List;


public interface AttributeService extends CrudService<AttributeEntity, AttributeDto, AttributeVo> {

    List<AttributeVo> getAllByAttributeGroupId(Long id, PaginationDto paginationDto);
    @Override
    void removeAll(List<Long> idList);
    void removeAllByAttributeGroupId(List<Long> idList);
}