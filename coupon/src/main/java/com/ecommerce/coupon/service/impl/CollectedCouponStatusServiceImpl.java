package com.ecommerce.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.coupon.dao.CollectedCouponStatusDao;
import com.ecommerce.coupon.dto.CollectedCouponStatusDto;
import com.ecommerce.coupon.entity.CollectedCouponStatusEntity;
import com.ecommerce.coupon.service.CollectedCouponStatusService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class CollectedCouponStatusServiceImpl extends CrudServiceImpl<CollectedCouponStatusDao, CollectedCouponStatusEntity, CollectedCouponStatusDto> implements CollectedCouponStatusService {

    @Override
    public QueryWrapper<CollectedCouponStatusEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<CollectedCouponStatusEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}