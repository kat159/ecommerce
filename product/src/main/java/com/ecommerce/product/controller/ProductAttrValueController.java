package com.ecommerce.product.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.product.entity.ProductAttrValueEntity;
import com.ecommerce.product.service.ProductAttrValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * spu属性值
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("product/productattrvalue")
public class ProductAttrValueController {
    @Autowired
    private ProductAttrValueService productAttrValueService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = productAttrValueService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        ProductAttrValueEntity productAttrValue = productAttrValueService.getById(id);

        return R.ok().put("productAttrValue", productAttrValue);
    }

    @PostMapping
        public R save(@RequestBody ProductAttrValueEntity productAttrValue){

        productAttrValueService.save(productAttrValue);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody ProductAttrValueEntity productAttrValue){
            productAttrValueService.updateById(productAttrValue);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            productAttrValueService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}