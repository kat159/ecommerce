package com.ecommerce.product.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.product.entity.SkuSaleAttrValueEntity;
import com.ecommerce.product.service.SkuSaleAttrValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * sku销售属性&值
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("product/skusaleattrvalue")
public class SkuSaleAttrValueController {
    @Autowired
    private SkuSaleAttrValueService skuSaleAttrValueService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = skuSaleAttrValueService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        SkuSaleAttrValueEntity skuSaleAttrValue = skuSaleAttrValueService.getById(id);

        return R.ok().put("skuSaleAttrValue", skuSaleAttrValue);
    }

    @PostMapping
        public R save(@RequestBody SkuSaleAttrValueEntity skuSaleAttrValue){

        skuSaleAttrValueService.save(skuSaleAttrValue);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody SkuSaleAttrValueEntity skuSaleAttrValue){
            skuSaleAttrValueService.updateById(skuSaleAttrValue);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            skuSaleAttrValueService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}