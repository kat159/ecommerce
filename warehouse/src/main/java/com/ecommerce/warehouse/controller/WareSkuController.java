package com.ecommerce.warehouse.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.warehouse.entity.WareSkuEntity;
import com.ecommerce.warehouse.service.WareSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 商品库存
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-19
 */
@RestController
@RequestMapping("warehouse/waresku")
public class WareSkuController {
    @Autowired
    private WareSkuService wareSkuService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = wareSkuService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        WareSkuEntity wareSku = wareSkuService.getById(id);

        return R.ok().put("wareSku", wareSku);
    }

    @PostMapping
        public R save(@RequestBody WareSkuEntity wareSku){

        wareSkuService.save(wareSku);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody WareSkuEntity wareSku){
            wareSkuService.updateById(wareSku);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            wareSkuService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}