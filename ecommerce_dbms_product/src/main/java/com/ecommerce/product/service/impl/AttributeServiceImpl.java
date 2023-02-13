package com.ecommerce.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.common.utils.ConvertUtils;
import com.ecommerce.product.dao.AttributeDao;
import com.ecommerce.product.dto.AttributeDto;
import com.ecommerce.product.entity.AttributeEntity;
import com.ecommerce.product.service.AttributeService;
import com.ecommerce.product.vo.AttributeVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class AttributeServiceImpl
        extends CrudServiceImpl<AttributeDao, AttributeEntity, AttributeDto, AttributeVo>
        implements AttributeService {

    @Override
    public List<AttributeVo> getAllByAttributeGroupId(Long id, PaginationDto paginationDto) {
        QueryWrapper<AttributeEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("attribute_group_id", id);
        return getAll(queryWrapper);
    }

    @Override
    protected AttributeEntity dtoToEntity(AttributeDto dto) {
        AttributeEntity entity = new AttributeEntity();
        BeanUtils.copyProperties(dto, entity);
        entity.setSelectableValueList( // dto: list<string>, to database: string
                ConvertUtils.listToString(dto.getSelectableValueList())
        );
        return entity;
    }

    @Override
    protected AttributeVo entityToVo(AttributeEntity entity) {
        AttributeVo vo = new AttributeVo();
        BeanUtils.copyProperties(entity, vo);
        vo.setSelectableValueList( // database: string, to vo: list<string>
                ConvertUtils.stringToList(entity.getSelectableValueList())
        );
        return vo;
    }
}