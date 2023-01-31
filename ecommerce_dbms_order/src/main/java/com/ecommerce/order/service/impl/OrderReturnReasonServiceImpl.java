package com.ecommerce.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.order.dao.OrderReturnReasonDao;
import com.ecommerce.order.dto.OrderReturnReasonDto;
import com.ecommerce.order.entity.OrderReturnReasonEntity;
import com.ecommerce.order.service.OrderReturnReasonService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class OrderReturnReasonServiceImpl extends CrudServiceImpl<OrderReturnReasonDao, OrderReturnReasonEntity, OrderReturnReasonDto> implements OrderReturnReasonService {

    @Override
    public QueryWrapper<OrderReturnReasonEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<OrderReturnReasonEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}