package com.ecommerce.coupon.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.coupon.entity.SkuFullReductionEntity;
import com.ecommerce.coupon.service.SkuFullReductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 商品满减信息
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("coupon/skufullreduction")
public class SkuFullReductionController {
    @Autowired
    private SkuFullReductionService skuFullReductionService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = skuFullReductionService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        SkuFullReductionEntity skuFullReduction = skuFullReductionService.getById(id);

        return R.ok().put("skuFullReduction", skuFullReduction);
    }

    @PostMapping
        public R save(@RequestBody SkuFullReductionEntity skuFullReduction){

        skuFullReductionService.save(skuFullReduction);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody SkuFullReductionEntity skuFullReduction){
            skuFullReductionService.updateById(skuFullReduction);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            skuFullReductionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}