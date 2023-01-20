package com.ecommerce.product.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.product.entity.SpuInfoDescEntity;
import com.ecommerce.product.service.SpuInfoDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * spu信息介绍
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("product/spuinfodesc")
public class SpuInfoDescController {
    @Autowired
    private SpuInfoDescService spuInfoDescService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = spuInfoDescService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{spuId}")
        public R get(@PathVariable("spuId") Long spuId){
        SpuInfoDescEntity spuInfoDesc = spuInfoDescService.getById(spuId);

        return R.ok().put("spuInfoDesc", spuInfoDesc);
    }

    @PostMapping
        public R save(@RequestBody SpuInfoDescEntity spuInfoDesc){

        spuInfoDescService.save(spuInfoDesc);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody SpuInfoDescEntity spuInfoDesc){
            spuInfoDescService.updateById(spuInfoDesc);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] spuIds){
            spuInfoDescService.removeByIds(Arrays.asList(spuIds));

        return R.ok();
    }
}