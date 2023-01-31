package com.ecommerce.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.product.dao.ProductAttrbuteValueDao;
import com.ecommerce.product.dto.ProductAttrbuteValueDto;
import com.ecommerce.product.entity.ProductAttrbuteValueEntity;
import com.ecommerce.product.service.ProductAttrbuteValueService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class ProductAttrbuteValueServiceImpl extends CrudServiceImpl<ProductAttrbuteValueDao, ProductAttrbuteValueEntity, ProductAttrbuteValueDto> implements ProductAttrbuteValueService {

    @Override
    public QueryWrapper<ProductAttrbuteValueEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<ProductAttrbuteValueEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}