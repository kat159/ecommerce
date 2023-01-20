package com.ecommerce.coupon.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.coupon.entity.SeckillSkuNoticeEntity;
import com.ecommerce.coupon.service.SeckillSkuNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 秒杀商品通知订阅
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("coupon/seckillskunotice")
public class SeckillSkuNoticeController {
    @Autowired
    private SeckillSkuNoticeService seckillSkuNoticeService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = seckillSkuNoticeService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        SeckillSkuNoticeEntity seckillSkuNotice = seckillSkuNoticeService.getById(id);

        return R.ok().put("seckillSkuNotice", seckillSkuNotice);
    }

    @PostMapping
        public R save(@RequestBody SeckillSkuNoticeEntity seckillSkuNotice){

        seckillSkuNoticeService.save(seckillSkuNotice);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody SeckillSkuNoticeEntity seckillSkuNotice){
            seckillSkuNoticeService.updateById(seckillSkuNotice);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            seckillSkuNoticeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}