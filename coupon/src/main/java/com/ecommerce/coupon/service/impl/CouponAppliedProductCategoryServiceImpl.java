package com.ecommerce.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.coupon.dao.CouponAppliedProductCategoryDao;
import com.ecommerce.coupon.dto.CouponAppliedProductCategoryDto;
import com.ecommerce.coupon.entity.CouponAppliedProductCategoryEntity;
import com.ecommerce.coupon.service.CouponAppliedProductCategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class CouponAppliedProductCategoryServiceImpl extends CrudServiceImpl<CouponAppliedProductCategoryDao, CouponAppliedProductCategoryEntity, CouponAppliedProductCategoryDto> implements CouponAppliedProductCategoryService {

    @Override
    public QueryWrapper<CouponAppliedProductCategoryEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<CouponAppliedProductCategoryEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}