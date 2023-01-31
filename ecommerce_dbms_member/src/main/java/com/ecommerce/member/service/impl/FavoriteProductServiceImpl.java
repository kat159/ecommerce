package com.ecommerce.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.member.dao.FavoriteProductDao;
import com.ecommerce.member.dto.FavoriteProductDto;
import com.ecommerce.member.entity.FavoriteProductEntity;
import com.ecommerce.member.service.FavoriteProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class FavoriteProductServiceImpl extends CrudServiceImpl<FavoriteProductDao, FavoriteProductEntity, FavoriteProductDto> implements FavoriteProductService {

    @Override
    public QueryWrapper<FavoriteProductEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<FavoriteProductEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}