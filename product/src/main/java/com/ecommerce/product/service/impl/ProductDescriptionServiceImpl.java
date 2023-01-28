package com.ecommerce.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.product.dao.ProductDescriptionDao;
import com.ecommerce.product.dto.ProductDescriptionDto;
import com.ecommerce.product.entity.ProductDescriptionEntity;
import com.ecommerce.product.service.ProductDescriptionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class ProductDescriptionServiceImpl extends CrudServiceImpl<ProductDescriptionDao, ProductDescriptionEntity, ProductDescriptionDto> implements ProductDescriptionService {

    @Override
    public QueryWrapper<ProductDescriptionEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<ProductDescriptionEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}