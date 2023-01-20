package com.ecommerce.product.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.product.entity.CategoryEntity;
import com.ecommerce.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 商品三级分类
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list/tree")  // url: http://localhost:9999/product/category/list/tree
    public R list(){
        return R.ok().put("data", categoryService.listWithTree());
    }

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = categoryService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{catId}")
        public R get(@PathVariable("catId") Long catId){
        CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("category", category);
    }

    @PostMapping
        public R save(@RequestBody CategoryEntity category){

        categoryService.save(category);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody CategoryEntity category){
            categoryService.updateById(category);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] catIds){
            categoryService.removeByIds(Arrays.asList(catIds));

        return R.ok();
    }
}