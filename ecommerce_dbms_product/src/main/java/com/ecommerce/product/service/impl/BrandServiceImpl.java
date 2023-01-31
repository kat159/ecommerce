package com.ecommerce.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.product.dao.BrandDao;
import com.ecommerce.product.dto.BrandDto;
import com.ecommerce.product.entity.BrandEntity;
import com.ecommerce.product.service.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class BrandServiceImpl extends CrudServiceImpl<BrandDao, BrandEntity, BrandDto> implements BrandService {

    @Override
    public QueryWrapper<BrandEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<BrandEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}