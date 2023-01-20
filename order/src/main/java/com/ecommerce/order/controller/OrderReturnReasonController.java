package com.ecommerce.order.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.order.entity.OrderReturnReasonEntity;
import com.ecommerce.order.service.OrderReturnReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 退货原因
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("order/orderreturnreason")
public class OrderReturnReasonController {
    @Autowired
    private OrderReturnReasonService orderReturnReasonService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = orderReturnReasonService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        OrderReturnReasonEntity orderReturnReason = orderReturnReasonService.getById(id);

        return R.ok().put("orderReturnReason", orderReturnReason);
    }

    @PostMapping
        public R save(@RequestBody OrderReturnReasonEntity orderReturnReason){

        orderReturnReasonService.save(orderReturnReason);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody OrderReturnReasonEntity orderReturnReason){
            orderReturnReasonService.updateById(orderReturnReason);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            orderReturnReasonService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}