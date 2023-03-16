package com.ecommerce.order.service;

import com.ecommerce.order.dto.OrderCheckoutDto;
import com.ecommerce.order.dto.PlaceOrderDto;
import com.ecommerce.order.entity.Order;
import com.ecommerce.order.vo.OrderCheckoutVo;

public interface OrderService {
    OrderCheckoutVo checkout(OrderCheckoutDto orderCheckoutDto);
    void placeOrder(PlaceOrderDto placeOrderDto);
}
