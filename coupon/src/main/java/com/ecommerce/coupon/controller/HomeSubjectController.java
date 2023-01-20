package com.ecommerce.coupon.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.coupon.entity.HomeSubjectEntity;
import com.ecommerce.coupon.service.HomeSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("coupon/homesubject")
public class HomeSubjectController {
    @Autowired
    private HomeSubjectService homeSubjectService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = homeSubjectService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        HomeSubjectEntity homeSubject = homeSubjectService.getById(id);

        return R.ok().put("homeSubject", homeSubject);
    }

    @PostMapping
        public R save(@RequestBody HomeSubjectEntity homeSubject){

        homeSubjectService.save(homeSubject);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody HomeSubjectEntity homeSubject){
            homeSubjectService.updateById(homeSubject);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            homeSubjectService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}