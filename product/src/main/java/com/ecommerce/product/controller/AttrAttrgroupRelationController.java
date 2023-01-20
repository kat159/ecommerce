package com.ecommerce.product.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.product.entity.AttrAttrgroupRelationEntity;
import com.ecommerce.product.service.AttrAttrgroupRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 属性&属性分组关联
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("product/attrattrgrouprelation")
public class AttrAttrgroupRelationController {
    @Autowired
    private AttrAttrgroupRelationService attrAttrgroupRelationService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = attrAttrgroupRelationService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        AttrAttrgroupRelationEntity attrAttrgroupRelation = attrAttrgroupRelationService.getById(id);

        return R.ok().put("attrAttrgroupRelation", attrAttrgroupRelation);
    }

    @PostMapping
        public R save(@RequestBody AttrAttrgroupRelationEntity attrAttrgroupRelation){

        attrAttrgroupRelationService.save(attrAttrgroupRelation);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody AttrAttrgroupRelationEntity attrAttrgroupRelation){
            attrAttrgroupRelationService.updateById(attrAttrgroupRelation);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            attrAttrgroupRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}