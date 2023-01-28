package com.ecommerce.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.coupon.dao.HomepageSubjectProductDao;
import com.ecommerce.coupon.dto.HomepageSubjectProductDto;
import com.ecommerce.coupon.entity.HomepageSubjectProductEntity;
import com.ecommerce.coupon.service.HomepageSubjectProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class HomepageSubjectProductServiceImpl extends CrudServiceImpl<HomepageSubjectProductDao, HomepageSubjectProductEntity, HomepageSubjectProductDto> implements HomepageSubjectProductService {

    @Override
    public QueryWrapper<HomepageSubjectProductEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<HomepageSubjectProductEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}