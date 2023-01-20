package com.ecommerce.product.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.product.entity.SkuImagesEntity;
import com.ecommerce.product.service.SkuImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * sku图片
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("product/skuimages")
public class SkuImagesController {
    @Autowired
    private SkuImagesService skuImagesService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = skuImagesService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        SkuImagesEntity skuImages = skuImagesService.getById(id);

        return R.ok().put("skuImages", skuImages);
    }

    @PostMapping
        public R save(@RequestBody SkuImagesEntity skuImages){

        skuImagesService.save(skuImages);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody SkuImagesEntity skuImages){
            skuImagesService.updateById(skuImages);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            skuImagesService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}