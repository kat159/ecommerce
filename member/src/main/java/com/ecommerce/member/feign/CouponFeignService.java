package com.ecommerce.member.feign;

import com.ecommerce.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("ecommerce-coupon-service")
public interface CouponFeignService {

    @GetMapping("coupon/coupon/member/list")
    public R memberCoupons();
}
