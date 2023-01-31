package com.ecommerce.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.coupon.dao.CouponDao;
import com.ecommerce.coupon.dto.CouponDto;
import com.ecommerce.coupon.entity.CouponEntity;
import com.ecommerce.coupon.service.CouponService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class CouponServiceImpl extends CrudServiceImpl<CouponDao, CouponEntity, CouponDto> implements CouponService {

    @Override
    public QueryWrapper<CouponEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<CouponEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}