package com.ecommerce.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.coupon.dao.SkuPriceBreakDao;
import com.ecommerce.coupon.dto.SkuPriceBreakDto;
import com.ecommerce.coupon.entity.SkuPriceBreakEntity;
import com.ecommerce.coupon.service.SkuPriceBreakService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class SkuPriceBreakServiceImpl extends CrudServiceImpl<SkuPriceBreakDao, SkuPriceBreakEntity, SkuPriceBreakDto> implements SkuPriceBreakService {

    @Override
    public QueryWrapper<SkuPriceBreakEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<SkuPriceBreakEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}