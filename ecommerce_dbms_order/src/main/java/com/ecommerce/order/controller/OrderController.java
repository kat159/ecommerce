package com.ecommerce.order.controller;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.dto.internal_dto.OrderSkuInternalDto;
import com.ecommerce.common.utils.Result;
import com.ecommerce.order.dto.OrderCheckoutDto;
import com.ecommerce.order.dto.PlaceOrderDto;
import com.ecommerce.order.entity.Order;
import com.ecommerce.order.open_feign.ProductClient;
import com.ecommerce.order.repository.OrderRepository;
import com.ecommerce.order.service.OrderService;
import com.ecommerce.order.vo.OrderCheckoutVo;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("order/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductClient productClient;

    @GetMapping("{id}")
    public Result<Order> getOrder(@PathVariable Long id) {
        return null;
    }

    @GetMapping("uuid/{uuid}")
    public Result<Order> getOrderByUUID(@PathVariable String uuid) {
        Order order = orderRepository.findByOrderUUID(uuid);
        return new Result<Order>().ok(order);
    }

    @PostMapping("checkout")
    public Result checkout(@RequestBody OrderCheckoutDto orderCheckoutDto) {
        OrderCheckoutVo orderCheckoutVo = orderService.checkout(orderCheckoutDto);
        return new Result().ok(orderCheckoutVo);
    }

    @PostMapping
    public Result placeOrder(@RequestBody PlaceOrderDto placeOrderDto) {
        orderService.placeOrder(placeOrderDto);
        return new Result();
    }


    @GetMapping("test")
    public Result test() {
        System.out.println("test");
        // Object obj = productClient.test();
        // System.out.println(obj);
        // Result skus = productClient.getAll(new PaginationDto());
        // System.out.println(skus);
        Result res = productClient.test(new PaginationDto());
        System.out.println(res);
        return res;
    }
    @PostMapping("test")
    public Result test2(PaginationDto paginationDto) {
        Result res = productClient.test2(new PaginationDto());
        System.out.println(res);
        return res;
    }

    @GetMapping("test3")
    public Result test3(PaginationDto paginationDto) {
        return new Result().ok(paginationDto);
    }
    @PostMapping("test3")
    public Result test4(PaginationDto paginationDto) {
        return new Result().ok(paginationDto);
    }
    @PutMapping("test3")
    public Result test5() {
        List<OrderSkuInternalDto> list = new ArrayList<>();
        OrderSkuInternalDto dto = new OrderSkuInternalDto();
        dto.setSkuId(1L);
        list.add(dto);
        return new Result().ok(productClient.deductInventory(list));
        // return new Result().ok(productClient.test3(list));
    }
}
