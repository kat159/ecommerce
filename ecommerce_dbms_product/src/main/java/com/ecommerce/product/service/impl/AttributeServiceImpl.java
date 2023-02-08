package com.ecommerce.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.product.dao.AttributeDao;
import com.ecommerce.product.dto.AttributeDto;
import com.ecommerce.product.entity.AttributeEntity;
import com.ecommerce.product.service.AttributeService;
import com.ecommerce.product.vo.AttributeVo;
import org.springframework.stereotype.Service;

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
}