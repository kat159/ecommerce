package com.ecommerce.order.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.order.entity.OrderItemEntity;
import com.ecommerce.order.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 订单项信息
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("order/orderitem")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = orderItemService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        OrderItemEntity orderItem = orderItemService.getById(id);

        return R.ok().put("orderItem", orderItem);
    }

    @PostMapping
        public R save(@RequestBody OrderItemEntity orderItem){

        orderItemService.save(orderItem);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody OrderItemEntity orderItem){
            orderItemService.updateById(orderItem);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            orderItemService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}