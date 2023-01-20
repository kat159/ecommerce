package com.ecommerce.order.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.order.entity.OrderSettingEntity;
import com.ecommerce.order.service.OrderSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 订单配置信息
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("order/ordersetting")
public class OrderSettingController {
    @Autowired
    private OrderSettingService orderSettingService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = orderSettingService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        OrderSettingEntity orderSetting = orderSettingService.getById(id);

        return R.ok().put("orderSetting", orderSetting);
    }

    @PostMapping
        public R save(@RequestBody OrderSettingEntity orderSetting){

        orderSettingService.save(orderSetting);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody OrderSettingEntity orderSetting){
            orderSettingService.updateById(orderSetting);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            orderSettingService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}