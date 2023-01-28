package com.ecommerce.order.service;

import com.ecommerce.common.service.CrudService;
import com.ecommerce.order.dto.OrderDto;
import com.ecommerce.order.entity.OrderEntity;


public interface OrderService extends CrudService<OrderEntity, OrderDto> {

}