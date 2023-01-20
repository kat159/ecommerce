package com.ecommerce.coupon.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.coupon.entity.CouponHistoryEntity;
import com.ecommerce.coupon.service.CouponHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 优惠券领取历史记录
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("coupon/couponhistory")
public class CouponHistoryController {
    @Autowired
    private CouponHistoryService couponHistoryService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = couponHistoryService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        CouponHistoryEntity couponHistory = couponHistoryService.getById(id);

        return R.ok().put("couponHistory", couponHistory);
    }

    @PostMapping
        public R save(@RequestBody CouponHistoryEntity couponHistory){

        couponHistoryService.save(couponHistory);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody CouponHistoryEntity couponHistory){
            couponHistoryService.updateById(couponHistory);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            couponHistoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}