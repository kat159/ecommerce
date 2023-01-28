package com.ecommerce.warehouse.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.warehouse.dao.OrderTaskDetailDao;
import com.ecommerce.warehouse.dto.OrderTaskDetailDto;
import com.ecommerce.warehouse.entity.OrderTaskDetailEntity;
import com.ecommerce.warehouse.service.OrderTaskDetailService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class OrderTaskDetailServiceImpl extends CrudServiceImpl<OrderTaskDetailDao, OrderTaskDetailEntity, OrderTaskDetailDto> implements OrderTaskDetailService {

    @Override
    public QueryWrapper<OrderTaskDetailEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<OrderTaskDetailEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}