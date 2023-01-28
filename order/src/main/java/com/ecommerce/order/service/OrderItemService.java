package com.ecommerce.order.service;

import com.ecommerce.common.service.CrudService;
import com.ecommerce.order.dto.OrderItemDto;
import com.ecommerce.order.entity.OrderItemEntity;


public interface OrderItemService extends CrudService<OrderItemEntity, OrderItemDto> {

}