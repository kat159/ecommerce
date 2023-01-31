package com.ecommerce.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.coupon.dao.PromotionDao;
import com.ecommerce.coupon.dto.PromotionDto;
import com.ecommerce.coupon.entity.PromotionEntity;
import com.ecommerce.coupon.service.PromotionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class PromotionServiceImpl extends CrudServiceImpl<PromotionDao, PromotionEntity, PromotionDto> implements PromotionService {

    @Override
    public QueryWrapper<PromotionEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<PromotionEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}