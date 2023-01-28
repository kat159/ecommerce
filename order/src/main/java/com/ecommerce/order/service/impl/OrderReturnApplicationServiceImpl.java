package com.ecommerce.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.order.dao.OrderReturnApplicationDao;
import com.ecommerce.order.dto.OrderReturnApplicationDto;
import com.ecommerce.order.entity.OrderReturnApplicationEntity;
import com.ecommerce.order.service.OrderReturnApplicationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class OrderReturnApplicationServiceImpl extends CrudServiceImpl<OrderReturnApplicationDao, OrderReturnApplicationEntity, OrderReturnApplicationDto> implements OrderReturnApplicationService {

    @Override
    public QueryWrapper<OrderReturnApplicationEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<OrderReturnApplicationEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}