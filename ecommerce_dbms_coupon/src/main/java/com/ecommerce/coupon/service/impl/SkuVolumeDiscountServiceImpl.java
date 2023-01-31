package com.ecommerce.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.coupon.dao.SkuVolumeDiscountDao;
import com.ecommerce.coupon.dto.SkuVolumeDiscountDto;
import com.ecommerce.coupon.entity.SkuVolumeDiscountEntity;
import com.ecommerce.coupon.service.SkuVolumeDiscountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class SkuVolumeDiscountServiceImpl extends CrudServiceImpl<SkuVolumeDiscountDao, SkuVolumeDiscountEntity, SkuVolumeDiscountDto> implements SkuVolumeDiscountService {

    @Override
    public QueryWrapper<SkuVolumeDiscountEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<SkuVolumeDiscountEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}