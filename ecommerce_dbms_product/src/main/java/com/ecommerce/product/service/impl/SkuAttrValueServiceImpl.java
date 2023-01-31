package com.ecommerce.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.product.dao.SkuAttrValueDao;
import com.ecommerce.product.dto.SkuAttrValueDto;
import com.ecommerce.product.entity.SkuAttrValueEntity;
import com.ecommerce.product.service.SkuAttrValueService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class SkuAttrValueServiceImpl extends CrudServiceImpl<SkuAttrValueDao, SkuAttrValueEntity, SkuAttrValueDto> implements SkuAttrValueService {

    @Override
    public QueryWrapper<SkuAttrValueEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<SkuAttrValueEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}