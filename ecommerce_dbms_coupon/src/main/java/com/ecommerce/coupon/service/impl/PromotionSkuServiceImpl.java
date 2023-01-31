package com.ecommerce.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.coupon.dao.PromotionSkuDao;
import com.ecommerce.coupon.dto.PromotionSkuDto;
import com.ecommerce.coupon.entity.PromotionSkuEntity;
import com.ecommerce.coupon.service.PromotionSkuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class PromotionSkuServiceImpl extends CrudServiceImpl<PromotionSkuDao, PromotionSkuEntity, PromotionSkuDto> implements PromotionSkuService {

    @Override
    public QueryWrapper<PromotionSkuEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<PromotionSkuEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}