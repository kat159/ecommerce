package com.ecommerce.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.product.dao.SkuImgDao;
import com.ecommerce.product.dto.SkuImgDto;
import com.ecommerce.product.entity.SkuImgEntity;
import com.ecommerce.product.service.SkuImgService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class SkuImgServiceImpl extends CrudServiceImpl<SkuImgDao, SkuImgEntity, SkuImgDto> implements SkuImgService {

    @Override
    public QueryWrapper<SkuImgEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<SkuImgEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}