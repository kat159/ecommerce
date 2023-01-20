package com.ecommerce.coupon.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.coupon.entity.CouponEntity;
import com.ecommerce.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 优惠券信息
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RefreshScope(proxyMode = ScopedProxyMode.DEFAULT)
@RestController
@RequestMapping("coupon/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @Value("${coupon.user.name}")
    private String name;
    @Value("${coupon.user.age}")
    private Integer age;
    @GetMapping("test") // test url: http://localhost:7000/coupon/coupon/test
    public R test(){
        return R.ok().put("name", name).put("age", age);
    }

    // test url: http://localhost:7000/coupon/coupon/member/list
    @GetMapping("/member/list")
    public R memberCoupons(){
        CouponEntity couponEntity = new CouponEntity();
        couponEntity.setCouponName("满100减10");
        return R.ok().put("coupons", Arrays.asList(couponEntity));
    }

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = couponService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        CouponEntity coupon = couponService.getById(id);

        return R.ok().put("coupon", coupon);
    }

    @PostMapping
        public R save(@RequestBody CouponEntity coupon){

        couponService.save(coupon);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody CouponEntity coupon){
            couponService.updateById(coupon);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            couponService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}