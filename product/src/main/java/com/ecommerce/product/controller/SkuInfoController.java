package com.ecommerce.product.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.product.entity.SkuInfoEntity;
import com.ecommerce.product.service.SkuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * sku信息
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("product/skuinfo")
public class SkuInfoController {
    @Autowired
    private SkuInfoService skuInfoService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = skuInfoService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{skuId}")
        public R get(@PathVariable("skuId") Long skuId){
        SkuInfoEntity skuInfo = skuInfoService.getById(skuId);

        return R.ok().put("skuInfo", skuInfo);
    }

    @PostMapping
        public R save(@RequestBody SkuInfoEntity skuInfo){

        skuInfoService.save(skuInfo);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody SkuInfoEntity skuInfo){
            skuInfoService.updateById(skuInfo);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] skuIds){
            skuInfoService.removeByIds(Arrays.asList(skuIds));

        return R.ok();
    }
}