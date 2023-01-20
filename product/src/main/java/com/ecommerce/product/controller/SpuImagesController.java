package com.ecommerce.product.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.product.entity.SpuImagesEntity;
import com.ecommerce.product.service.SpuImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * spu图片
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("product/spuimages")
public class SpuImagesController {
    @Autowired
    private SpuImagesService spuImagesService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = spuImagesService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        SpuImagesEntity spuImages = spuImagesService.getById(id);

        return R.ok().put("spuImages", spuImages);
    }

    @PostMapping
        public R save(@RequestBody SpuImagesEntity spuImages){

        spuImagesService.save(spuImages);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody SpuImagesEntity spuImages){
            spuImagesService.updateById(spuImages);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            spuImagesService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}