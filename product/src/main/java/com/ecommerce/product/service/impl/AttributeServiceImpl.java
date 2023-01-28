package com.ecommerce.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.product.dao.AttributeDao;
import com.ecommerce.product.dto.AttributeDto;
import com.ecommerce.product.entity.AttributeEntity;
import com.ecommerce.product.service.AttributeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class AttributeServiceImpl extends CrudServiceImpl<AttributeDao, AttributeEntity, AttributeDto> implements AttributeService {

    @Override
    public QueryWrapper<AttributeEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<AttributeEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}