package com.ecommerce.product.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.product.entity.AttrGroupEntity;
import com.ecommerce.product.service.AttrGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 属性分组
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = attrGroupService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{attrGroupId}")
        public R get(@PathVariable("attrGroupId") Long attrGroupId){
        AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);

        return R.ok().put("attrGroup", attrGroup);
    }

    @PostMapping
        public R save(@RequestBody AttrGroupEntity attrGroup){

        attrGroupService.save(attrGroup);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody AttrGroupEntity attrGroup){
            attrGroupService.updateById(attrGroup);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] attrGroupIds){
            attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return R.ok();
    }
}