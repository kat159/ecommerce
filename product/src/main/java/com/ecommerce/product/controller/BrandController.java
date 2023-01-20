package com.ecommerce.product.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.product.entity.BrandEntity;
import com.ecommerce.product.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 品牌
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{brandId}")
        public R get(@PathVariable("brandId") Long brandId){
        BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    @PostMapping
        public R save(@RequestBody BrandEntity brand){

        brandService.save(brand);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody BrandEntity brand){
            brandService.updateById(brand);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] brandIds){
            brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }
}