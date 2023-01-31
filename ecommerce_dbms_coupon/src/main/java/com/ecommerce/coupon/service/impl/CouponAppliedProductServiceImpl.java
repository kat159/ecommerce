package com.ecommerce.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.coupon.dao.CouponAppliedProductDao;
import com.ecommerce.coupon.dto.CouponAppliedProductDto;
import com.ecommerce.coupon.entity.CouponAppliedProductEntity;
import com.ecommerce.coupon.service.CouponAppliedProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class CouponAppliedProductServiceImpl extends CrudServiceImpl<CouponAppliedProductDao, CouponAppliedProductEntity, CouponAppliedProductDto> implements CouponAppliedProductService {

    @Override
    public QueryWrapper<CouponAppliedProductEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<CouponAppliedProductEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}