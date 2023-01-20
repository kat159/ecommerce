package com.ecommerce.coupon.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.coupon.entity.CouponSpuRelationEntity;
import com.ecommerce.coupon.service.CouponSpuRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 优惠券与产品关联
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("coupon/couponspurelation")
public class CouponSpuRelationController {
    @Autowired
    private CouponSpuRelationService couponSpuRelationService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = couponSpuRelationService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        CouponSpuRelationEntity couponSpuRelation = couponSpuRelationService.getById(id);

        return R.ok().put("couponSpuRelation", couponSpuRelation);
    }

    @PostMapping
        public R save(@RequestBody CouponSpuRelationEntity couponSpuRelation){

        couponSpuRelationService.save(couponSpuRelation);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody CouponSpuRelationEntity couponSpuRelation){
            couponSpuRelationService.updateById(couponSpuRelation);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            couponSpuRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}