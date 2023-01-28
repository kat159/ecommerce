package com.ecommerce.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.order.dao.OrderOperationRecordDao;
import com.ecommerce.order.dto.OrderOperationRecordDto;
import com.ecommerce.order.entity.OrderOperationRecordEntity;
import com.ecommerce.order.service.OrderOperationRecordService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class OrderOperationRecordServiceImpl extends CrudServiceImpl<OrderOperationRecordDao, OrderOperationRecordEntity, OrderOperationRecordDto> implements OrderOperationRecordService {

    @Override
    public QueryWrapper<OrderOperationRecordEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<OrderOperationRecordEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}