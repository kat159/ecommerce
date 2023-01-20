package com.ecommerce.coupon.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.coupon.entity.HomeAdvEntity;
import com.ecommerce.coupon.service.HomeAdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 首页轮播广告
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("coupon/homeadv")
public class HomeAdvController {
    @Autowired
    private HomeAdvService homeAdvService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = homeAdvService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        HomeAdvEntity homeAdv = homeAdvService.getById(id);

        return R.ok().put("homeAdv", homeAdv);
    }

    @PostMapping
        public R save(@RequestBody HomeAdvEntity homeAdv){

        homeAdvService.save(homeAdv);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody HomeAdvEntity homeAdv){
            homeAdvService.updateById(homeAdv);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            homeAdvService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}