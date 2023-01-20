package com.ecommerce.coupon.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.coupon.entity.SpuBoundsEntity;
import com.ecommerce.coupon.service.SpuBoundsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 商品spu积分设置
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("coupon/spubounds")
public class SpuBoundsController {
    @Autowired
    private SpuBoundsService spuBoundsService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = spuBoundsService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        SpuBoundsEntity spuBounds = spuBoundsService.getById(id);

        return R.ok().put("spuBounds", spuBounds);
    }

    @PostMapping
        public R save(@RequestBody SpuBoundsEntity spuBounds){

        spuBoundsService.save(spuBounds);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody SpuBoundsEntity spuBounds){
            spuBoundsService.updateById(spuBounds);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            spuBoundsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}