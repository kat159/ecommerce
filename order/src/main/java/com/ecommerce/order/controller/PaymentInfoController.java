package com.ecommerce.order.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.order.entity.PaymentInfoEntity;
import com.ecommerce.order.service.PaymentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 支付信息表
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("order/paymentinfo")
public class PaymentInfoController {
    @Autowired
    private PaymentInfoService paymentInfoService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = paymentInfoService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        PaymentInfoEntity paymentInfo = paymentInfoService.getById(id);

        return R.ok().put("paymentInfo", paymentInfo);
    }

    @PostMapping
        public R save(@RequestBody PaymentInfoEntity paymentInfo){

        paymentInfoService.save(paymentInfo);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody PaymentInfoEntity paymentInfo){
            paymentInfoService.updateById(paymentInfo);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            paymentInfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}