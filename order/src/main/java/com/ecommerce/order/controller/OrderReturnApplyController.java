package com.ecommerce.order.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.order.entity.OrderReturnApplyEntity;
import com.ecommerce.order.service.OrderReturnApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 订单退货申请
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("order/orderreturnapply")
public class OrderReturnApplyController {
    @Autowired
    private OrderReturnApplyService orderReturnApplyService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = orderReturnApplyService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        OrderReturnApplyEntity orderReturnApply = orderReturnApplyService.getById(id);

        return R.ok().put("orderReturnApply", orderReturnApply);
    }

    @PostMapping
        public R save(@RequestBody OrderReturnApplyEntity orderReturnApply){

        orderReturnApplyService.save(orderReturnApply);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody OrderReturnApplyEntity orderReturnApply){
            orderReturnApplyService.updateById(orderReturnApply);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            orderReturnApplyService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}