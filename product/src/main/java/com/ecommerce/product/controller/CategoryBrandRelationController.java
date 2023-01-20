package com.ecommerce.product.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.product.entity.CategoryBrandRelationEntity;
import com.ecommerce.product.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 品牌分类关联
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("product/categorybrandrelation")
public class CategoryBrandRelationController {
    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = categoryBrandRelationService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        CategoryBrandRelationEntity categoryBrandRelation = categoryBrandRelationService.getById(id);

        return R.ok().put("categoryBrandRelation", categoryBrandRelation);
    }

    @PostMapping
        public R save(@RequestBody CategoryBrandRelationEntity categoryBrandRelation){

        categoryBrandRelationService.save(categoryBrandRelation);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody CategoryBrandRelationEntity categoryBrandRelation){
            categoryBrandRelationService.updateById(categoryBrandRelation);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            categoryBrandRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}