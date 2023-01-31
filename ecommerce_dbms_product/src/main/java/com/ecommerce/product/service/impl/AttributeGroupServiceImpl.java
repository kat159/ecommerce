package com.ecommerce.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.product.dao.AttributeGroupDao;
import com.ecommerce.product.dto.AttributeGroupDto;
import com.ecommerce.product.entity.AttributeGroupEntity;
import com.ecommerce.product.service.AttributeGroupService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class AttributeGroupServiceImpl extends CrudServiceImpl<AttributeGroupDao, AttributeGroupEntity, AttributeGroupDto> implements AttributeGroupService {

    @Override
    public QueryWrapper<AttributeGroupEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<AttributeGroupEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}