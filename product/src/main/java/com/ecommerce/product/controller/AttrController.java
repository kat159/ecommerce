package com.ecommerce.product.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.product.entity.AttrEntity;
import com.ecommerce.product.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 商品属性
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = attrService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{attrId}")
        public R get(@PathVariable("attrId") Long attrId){
        AttrEntity attr = attrService.getById(attrId);

        return R.ok().put("attr", attr);
    }

    @PostMapping
        public R save(@RequestBody AttrEntity attr){

        attrService.save(attr);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody AttrEntity attr){
            attrService.updateById(attr);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] attrIds){
            attrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }
}