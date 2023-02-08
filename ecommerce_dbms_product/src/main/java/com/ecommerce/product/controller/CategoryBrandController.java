package com.ecommerce.product.controller;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.ecommerce.product.dto.CategoryBrandDto;
import com.ecommerce.product.service.CategoryBrandService;
import com.ecommerce.product.vo.CategoryBrandVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("product/categorybrand")
@Api(tags="join table")
public class CategoryBrandController {
    @Autowired
    private CategoryBrandService categoryBrandService;

    @GetMapping("page")
    public Result page(@Valid PaginationDto params){
        PageData<CategoryBrandVo> page = categoryBrandService.page(params);
        return new Result().ok(page);
    }

    @GetMapping("{id}")
    public Result get(@PathVariable("id") Long id){
        CategoryBrandVo data = categoryBrandService.get(id);
        return new Result().ok(data);
    }

    @PostMapping
    public Result addAll(@RequestBody List<CategoryBrandDto> dtoList){
        List<Long> res = categoryBrandService.addAll(dtoList);
        return new Result().ok(res);
    }

    @PutMapping
    public Result updateAll(@RequestBody List<CategoryBrandDto> dtoList){
        categoryBrandService.updateAll(dtoList);
        return new Result();
    }

    @DeleteMapping
    public Result removeAll(@RequestBody List<Long> idList){
        categoryBrandService.removeAll(idList);
        return new Result();
    }
}