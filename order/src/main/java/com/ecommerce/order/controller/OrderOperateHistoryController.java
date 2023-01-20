package com.ecommerce.order.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.order.entity.OrderOperateHistoryEntity;
import com.ecommerce.order.service.OrderOperateHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 订单操作历史记录
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("order/orderoperatehistory")
public class OrderOperateHistoryController {
    @Autowired
    private OrderOperateHistoryService orderOperateHistoryService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = orderOperateHistoryService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        OrderOperateHistoryEntity orderOperateHistory = orderOperateHistoryService.getById(id);

        return R.ok().put("orderOperateHistory", orderOperateHistory);
    }

    @PostMapping
        public R save(@RequestBody OrderOperateHistoryEntity orderOperateHistory){

        orderOperateHistoryService.save(orderOperateHistory);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody OrderOperateHistoryEntity orderOperateHistory){
            orderOperateHistoryService.updateById(orderOperateHistory);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            orderOperateHistoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}