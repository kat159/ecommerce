package com.ecommerce.coupon.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.coupon.entity.SeckillSessionEntity;
import com.ecommerce.coupon.service.SeckillSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 秒杀活动场次
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("coupon/seckillsession")
public class SeckillSessionController {
    @Autowired
    private SeckillSessionService seckillSessionService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = seckillSessionService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        SeckillSessionEntity seckillSession = seckillSessionService.getById(id);

        return R.ok().put("seckillSession", seckillSession);
    }

    @PostMapping
        public R save(@RequestBody SeckillSessionEntity seckillSession){

        seckillSessionService.save(seckillSession);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody SeckillSessionEntity seckillSession){
            seckillSessionService.updateById(seckillSession);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            seckillSessionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}