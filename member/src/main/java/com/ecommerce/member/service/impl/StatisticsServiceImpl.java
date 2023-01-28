package com.ecommerce.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.member.dao.StatisticsDao;
import com.ecommerce.member.dto.StatisticsDto;
import com.ecommerce.member.entity.StatisticsEntity;
import com.ecommerce.member.service.StatisticsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class StatisticsServiceImpl extends CrudServiceImpl<StatisticsDao, StatisticsEntity, StatisticsDto> implements StatisticsService {

    @Override
    public QueryWrapper<StatisticsEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<StatisticsEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}