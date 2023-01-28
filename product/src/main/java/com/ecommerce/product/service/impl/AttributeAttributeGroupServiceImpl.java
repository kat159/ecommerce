package com.ecommerce.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.product.dao.AttributeAttributeGroupDao;
import com.ecommerce.product.dto.AttributeAttributeGroupDto;
import com.ecommerce.product.entity.AttributeAttributeGroupEntity;
import com.ecommerce.product.service.AttributeAttributeGroupService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class AttributeAttributeGroupServiceImpl extends CrudServiceImpl<AttributeAttributeGroupDao, AttributeAttributeGroupEntity, AttributeAttributeGroupDto> implements AttributeAttributeGroupService {

    @Override
    public QueryWrapper<AttributeAttributeGroupEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<AttributeAttributeGroupEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}