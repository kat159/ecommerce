package com.ecommerce.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.product.dao.ProductImagesDao;
import com.ecommerce.product.dto.ProductImagesDto;
import com.ecommerce.product.entity.ProductImagesEntity;
import com.ecommerce.product.service.ProductImagesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class ProductImagesServiceImpl extends CrudServiceImpl<ProductImagesDao, ProductImagesEntity, ProductImagesDto> implements ProductImagesService {

    @Override
    public QueryWrapper<ProductImagesEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<ProductImagesEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}