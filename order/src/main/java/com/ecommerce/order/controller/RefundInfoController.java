package com.ecommerce.order.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.order.entity.RefundInfoEntity;
import com.ecommerce.order.service.RefundInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 退款信息
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("order/refundinfo")
public class RefundInfoController {
    @Autowired
    private RefundInfoService refundInfoService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = refundInfoService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        RefundInfoEntity refundInfo = refundInfoService.getById(id);

        return R.ok().put("refundInfo", refundInfo);
    }

    @PostMapping
        public R save(@RequestBody RefundInfoEntity refundInfo){

        refundInfoService.save(refundInfo);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody RefundInfoEntity refundInfo){
            refundInfoService.updateById(refundInfo);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            refundInfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}