package com.ecommerce.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.coupon.dao.ProductRewardDao;
import com.ecommerce.coupon.dto.ProductRewardDto;
import com.ecommerce.coupon.entity.ProductRewardEntity;
import com.ecommerce.coupon.service.ProductRewardService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class ProductRewardServiceImpl extends CrudServiceImpl<ProductRewardDao, ProductRewardEntity, ProductRewardDto> implements ProductRewardService {

    @Override
    public QueryWrapper<ProductRewardEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<ProductRewardEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}