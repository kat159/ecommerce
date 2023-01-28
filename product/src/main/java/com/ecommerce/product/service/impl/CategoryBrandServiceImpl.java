package com.ecommerce.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.product.dao.CategoryBrandDao;
import com.ecommerce.product.dto.CategoryBrandDto;
import com.ecommerce.product.entity.CategoryBrandEntity;
import com.ecommerce.product.service.CategoryBrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class CategoryBrandServiceImpl extends CrudServiceImpl<CategoryBrandDao, CategoryBrandEntity, CategoryBrandDto> implements CategoryBrandService {

    @Override
    public QueryWrapper<CategoryBrandEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<CategoryBrandEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}