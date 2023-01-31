package com.ecommerce.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.product.dao.ProductDao;
import com.ecommerce.product.dto.ProductDto;
import com.ecommerce.product.entity.ProductEntity;
import com.ecommerce.product.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class ProductServiceImpl extends CrudServiceImpl<ProductDao, ProductEntity, ProductDto> implements ProductService {

    @Override
    public QueryWrapper<ProductEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<ProductEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}