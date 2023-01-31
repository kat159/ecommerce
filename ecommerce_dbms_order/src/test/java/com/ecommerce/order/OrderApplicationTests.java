package com.ecommerce.order;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.order.dao.OrderDao;
import com.ecommerce.order.entity.OrderEntity;
import com.ecommerce.order.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderApplicationTests {

    @Autowired
    OrderDao orderDao;

    @Autowired
    OrderService orderService;

    @Test
    void contextLoads() {
    }

    @Test
    void testInsert() {
        for (int i = 0; i < 20; i++) {
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setOrderSn("test" + i);
            // orderService.save(orderEntity);
        }
    }

    @Test
    void testUpdate() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderSn("test_update");
        orderEntity.setId(1L);
        orderService.updateById(orderEntity);
    }

}
