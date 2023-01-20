package com.ecommerce.warehouse.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.warehouse.entity.PurchaseEntity;
import com.ecommerce.warehouse.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 采购信息
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-19
 */
@RestController
@RequestMapping("warehouse/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = purchaseService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        PurchaseEntity purchase = purchaseService.getById(id);

        return R.ok().put("purchase", purchase);
    }

    @PostMapping
        public R save(@RequestBody PurchaseEntity purchase){

        purchaseService.save(purchase);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody PurchaseEntity purchase){
            purchaseService.updateById(purchase);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            purchaseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}