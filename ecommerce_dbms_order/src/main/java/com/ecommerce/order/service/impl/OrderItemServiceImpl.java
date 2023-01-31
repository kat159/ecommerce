package com.ecommerce.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.order.dao.OrderItemDao;
import com.ecommerce.order.dto.OrderItemDto;
import com.ecommerce.order.entity.OrderItemEntity;
import com.ecommerce.order.service.OrderItemService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class OrderItemServiceImpl extends CrudServiceImpl<OrderItemDao, OrderItemEntity, OrderItemDto> implements OrderItemService {

    @Override
    public QueryWrapper<OrderItemEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<OrderItemEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}