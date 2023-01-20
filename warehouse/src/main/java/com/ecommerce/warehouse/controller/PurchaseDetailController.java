package com.ecommerce.warehouse.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.warehouse.entity.PurchaseDetailEntity;
import com.ecommerce.warehouse.service.PurchaseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-19
 */
@RestController
@RequestMapping("warehouse/purchasedetail")
public class PurchaseDetailController {
    @Autowired
    private PurchaseDetailService purchaseDetailService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = purchaseDetailService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        PurchaseDetailEntity purchaseDetail = purchaseDetailService.getById(id);

        return R.ok().put("purchaseDetail", purchaseDetail);
    }

    @PostMapping
        public R save(@RequestBody PurchaseDetailEntity purchaseDetail){

        purchaseDetailService.save(purchaseDetail);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody PurchaseDetailEntity purchaseDetail){
            purchaseDetailService.updateById(purchaseDetail);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            purchaseDetailService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}