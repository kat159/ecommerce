package com.ecommerce.coupon.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.coupon.entity.SeckillPromotionEntity;
import com.ecommerce.coupon.service.SeckillPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 秒杀活动
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("coupon/seckillpromotion")
public class SeckillPromotionController {
    @Autowired
    private SeckillPromotionService seckillPromotionService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = seckillPromotionService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        SeckillPromotionEntity seckillPromotion = seckillPromotionService.getById(id);

        return R.ok().put("seckillPromotion", seckillPromotion);
    }

    @PostMapping
        public R save(@RequestBody SeckillPromotionEntity seckillPromotion){

        seckillPromotionService.save(seckillPromotion);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody SeckillPromotionEntity seckillPromotion){
            seckillPromotionService.updateById(seckillPromotion);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            seckillPromotionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}