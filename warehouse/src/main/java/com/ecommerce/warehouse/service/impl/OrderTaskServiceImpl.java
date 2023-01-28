package com.ecommerce.warehouse.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.warehouse.dao.OrderTaskDao;
import com.ecommerce.warehouse.dto.OrderTaskDto;
import com.ecommerce.warehouse.entity.OrderTaskEntity;
import com.ecommerce.warehouse.service.OrderTaskService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class OrderTaskServiceImpl extends CrudServiceImpl<OrderTaskDao, OrderTaskEntity, OrderTaskDto> implements OrderTaskService {

    @Override
    public QueryWrapper<OrderTaskEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<OrderTaskEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}