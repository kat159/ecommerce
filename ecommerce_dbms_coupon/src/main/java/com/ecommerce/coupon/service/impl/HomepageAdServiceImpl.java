package com.ecommerce.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.coupon.dao.HomepageAdDao;
import com.ecommerce.coupon.dto.HomepageAdDto;
import com.ecommerce.coupon.entity.HomepageAdEntity;
import com.ecommerce.coupon.service.HomepageAdService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class HomepageAdServiceImpl extends CrudServiceImpl<HomepageAdDao, HomepageAdEntity, HomepageAdDto> implements HomepageAdService {

    @Override
    public QueryWrapper<HomepageAdEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<HomepageAdEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}