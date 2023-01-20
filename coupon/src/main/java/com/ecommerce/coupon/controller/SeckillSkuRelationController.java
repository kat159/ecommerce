package com.ecommerce.coupon.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.coupon.entity.SeckillSkuRelationEntity;
import com.ecommerce.coupon.service.SeckillSkuRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 秒杀活动商品关联
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("coupon/seckillskurelation")
public class SeckillSkuRelationController {
    @Autowired
    private SeckillSkuRelationService seckillSkuRelationService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = seckillSkuRelationService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        SeckillSkuRelationEntity seckillSkuRelation = seckillSkuRelationService.getById(id);

        return R.ok().put("seckillSkuRelation", seckillSkuRelation);
    }

    @PostMapping
        public R save(@RequestBody SeckillSkuRelationEntity seckillSkuRelation){

        seckillSkuRelationService.save(seckillSkuRelation);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody SeckillSkuRelationEntity seckillSkuRelation){
            seckillSkuRelationService.updateById(seckillSkuRelation);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            seckillSkuRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}