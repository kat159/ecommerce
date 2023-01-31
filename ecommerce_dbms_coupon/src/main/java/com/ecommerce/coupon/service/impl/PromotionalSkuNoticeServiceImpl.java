package com.ecommerce.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.coupon.dao.PromotionalSkuNoticeDao;
import com.ecommerce.coupon.dto.PromotionalSkuNoticeDto;
import com.ecommerce.coupon.entity.PromotionalSkuNoticeEntity;
import com.ecommerce.coupon.service.PromotionalSkuNoticeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class PromotionalSkuNoticeServiceImpl extends CrudServiceImpl<PromotionalSkuNoticeDao, PromotionalSkuNoticeEntity, PromotionalSkuNoticeDto> implements PromotionalSkuNoticeService {

    @Override
    public QueryWrapper<PromotionalSkuNoticeEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<PromotionalSkuNoticeEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}