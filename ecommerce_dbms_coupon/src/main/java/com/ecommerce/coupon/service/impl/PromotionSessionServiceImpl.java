package com.ecommerce.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.coupon.dao.PromotionSessionDao;
import com.ecommerce.coupon.dto.PromotionSessionDto;
import com.ecommerce.coupon.entity.PromotionSessionEntity;
import com.ecommerce.coupon.service.PromotionSessionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class PromotionSessionServiceImpl extends CrudServiceImpl<PromotionSessionDao, PromotionSessionEntity, PromotionSessionDto> implements PromotionSessionService {

    @Override
    public QueryWrapper<PromotionSessionEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<PromotionSessionEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}