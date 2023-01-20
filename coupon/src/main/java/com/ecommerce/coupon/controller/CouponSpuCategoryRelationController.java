package com.ecommerce.coupon.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.coupon.entity.CouponSpuCategoryRelationEntity;
import com.ecommerce.coupon.service.CouponSpuCategoryRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 优惠券分类关联
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("coupon/couponspucategoryrelation")
public class CouponSpuCategoryRelationController {
    @Autowired
    private CouponSpuCategoryRelationService couponSpuCategoryRelationService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = couponSpuCategoryRelationService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        CouponSpuCategoryRelationEntity couponSpuCategoryRelation = couponSpuCategoryRelationService.getById(id);

        return R.ok().put("couponSpuCategoryRelation", couponSpuCategoryRelation);
    }

    @PostMapping
        public R save(@RequestBody CouponSpuCategoryRelationEntity couponSpuCategoryRelation){

        couponSpuCategoryRelationService.save(couponSpuCategoryRelation);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody CouponSpuCategoryRelationEntity couponSpuCategoryRelation){
            couponSpuCategoryRelationService.updateById(couponSpuCategoryRelation);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            couponSpuCategoryRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}