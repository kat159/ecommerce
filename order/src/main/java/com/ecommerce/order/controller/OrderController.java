package com.ecommerce.order.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.order.entity.OrderEntity;
import com.ecommerce.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 订单
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("order/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = orderService.queryPage(params);

        return R.ok().put("page", page);
    }

    // url: http://localhost:8080/order/order/1
    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        OrderEntity order = orderService.getById(id);

        return R.ok().put("order", order);
    }

    @PostMapping
        public R save(@RequestBody OrderEntity order){

        orderService.save(order);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody OrderEntity order){
            orderService.updateById(order);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            orderService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}