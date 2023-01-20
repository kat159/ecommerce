package com.ecommerce.coupon.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.coupon.entity.SkuLadderEntity;
import com.ecommerce.coupon.service.SkuLadderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 商品阶梯价格
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("coupon/skuladder")
public class SkuLadderController {
    @Autowired
    private SkuLadderService skuLadderService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = skuLadderService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        SkuLadderEntity skuLadder = skuLadderService.getById(id);

        return R.ok().put("skuLadder", skuLadder);
    }

    @PostMapping
        public R save(@RequestBody SkuLadderEntity skuLadder){

        skuLadderService.save(skuLadder);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody SkuLadderEntity skuLadder){
            skuLadderService.updateById(skuLadder);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            skuLadderService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}