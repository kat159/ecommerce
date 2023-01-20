package com.ecommerce.product.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.product.entity.SpuInfoEntity;
import com.ecommerce.product.service.SpuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * spu信息
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("product/spuinfo")
public class SpuInfoController {
    @Autowired
    private SpuInfoService spuInfoService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = spuInfoService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        SpuInfoEntity spuInfo = spuInfoService.getById(id);

        return R.ok().put("spuInfo", spuInfo);
    }

    @PostMapping
        public R save(@RequestBody SpuInfoEntity spuInfo){

        spuInfoService.save(spuInfo);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody SpuInfoEntity spuInfo){
            spuInfoService.updateById(spuInfo);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            spuInfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}