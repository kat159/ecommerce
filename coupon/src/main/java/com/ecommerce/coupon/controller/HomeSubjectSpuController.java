package com.ecommerce.coupon.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.coupon.entity.HomeSubjectSpuEntity;
import com.ecommerce.coupon.service.HomeSubjectSpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 专题商品
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("coupon/homesubjectspu")
public class HomeSubjectSpuController {
    @Autowired
    private HomeSubjectSpuService homeSubjectSpuService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = homeSubjectSpuService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        HomeSubjectSpuEntity homeSubjectSpu = homeSubjectSpuService.getById(id);

        return R.ok().put("homeSubjectSpu", homeSubjectSpu);
    }

    @PostMapping
        public R save(@RequestBody HomeSubjectSpuEntity homeSubjectSpu){

        homeSubjectSpuService.save(homeSubjectSpu);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody HomeSubjectSpuEntity homeSubjectSpu){
            homeSubjectSpuService.updateById(homeSubjectSpu);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            homeSubjectSpuService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}