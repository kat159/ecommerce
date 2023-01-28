package com.ecommerce.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.coupon.dao.HomepageSubjectDao;
import com.ecommerce.coupon.dto.HomepageSubjectDto;
import com.ecommerce.coupon.entity.HomepageSubjectEntity;
import com.ecommerce.coupon.service.HomepageSubjectService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class HomepageSubjectServiceImpl extends CrudServiceImpl<HomepageSubjectDao, HomepageSubjectEntity, HomepageSubjectDto> implements HomepageSubjectService {

    @Override
    public QueryWrapper<HomepageSubjectEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<HomepageSubjectEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}