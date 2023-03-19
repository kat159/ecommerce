package com.ecommerce.product.controller;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.ecommerce.common.vo.AddResponseVo;
import com.ecommerce.product.dto.AttributeGroupDto;
import com.ecommerce.product.dto.CategoryDto;
import com.ecommerce.product.dto.aggregate.CategoryManageDto;
import com.ecommerce.product.dto.pagination.CategoryPaginationDto;
import com.ecommerce.product.service.CategoryService;
import com.ecommerce.product.vo.CategoryVo;
import com.ecommerce.product.vo.aggregate.CategoryManageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("product/category")
@Api(tags = "product category, up to three-level categorization")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/page")
    public Result page(@Valid PaginationDto params) {
        PageData<CategoryVo> page = categoryService.page(params);
        return new Result().ok(page);
    }

    @GetMapping("{id}")
    public Result get(@PathVariable("id") Long id) {
        CategoryVo data = categoryService.get(id);
        return new Result().ok(data);
    }

    // @GetMapping("/all")
    // public Result getAll() {
    //     List<CategoryVo> list = categoryService.getAll();
    //     return new Result().ok(list);
    // }
    @GetMapping("/all")
    public Result getAll(@Valid CategoryPaginationDto params) {
        List<CategoryVo> list = categoryService.getAll(params);
        return new Result().ok(list);
    }

    @PostMapping
    public Result addAll(@RequestBody List<CategoryDto> dtoList) {
        List<Long> res = categoryService.addAll(dtoList);
        return new Result().ok(res);
    }

    @PutMapping
    public Result updateAll(@RequestBody List<CategoryDto> dtoList) {
        categoryService.updateAll(dtoList);
        return new Result();
    }

    @DeleteMapping
    public Result removeAll(@RequestBody List<Long> idList) {
        categoryService.removeAll(idList);
        return new Result();
    }

    @GetMapping("/forest") // build category forest, return root node list
    public Result forest() { // build category forest, return root node List
        return new Result().ok(categoryService.getForest());
    }
    @GetMapping("manage/forest") // refactor, used by frontend page "src/pages/ProductManagement2/Category2.jsx"
    public Result forestV2() {
        return new Result().ok(categoryService.getForestV2());
    }
    @PutMapping("manage")
    public Result updateAllV2(@RequestBody CategoryManageDto dto) {
        categoryService.updateAllV2(dto);
        return new Result();
    }
    /**
     * Relational: One to Many <AttributeGroup>
     */
    @GetMapping("/{id}/attrgroup/page")
    public Result pageAttrGroup(@PathVariable("id") Long categoryId, @Valid PaginationDto params) {
        return new Result().ok(categoryService.pageAttrGroups(categoryId, params));
    }

    @GetMapping("{id}/attrgroup")
    public Result getAllAttrGroup(@PathVariable("id") Long categoryId, @Valid PaginationDto params) {
        return new Result().ok(categoryService.getAllAttrGroups(categoryId, params));
    }

    @PostMapping("{id}/attrgroup")
    public Result addAllAttrGroup(@PathVariable("id") Long categoryId, @RequestBody List<AttributeGroupDto> attributeGroupDtoList) {
        List<Long> idList = categoryService. addAllAttrGroup(categoryId, attributeGroupDtoList);
        return new Result().ok(idList);
    }

    @GetMapping("{id}/attrgroup/attribute")
    public Result getAllAttrGroupWithAttrList(@PathVariable("id") Long categoryId) {
        System.out.println("getAllAttrGroupWithAttrList");
        return new Result().ok(categoryService.getAllAttrGroupWithAttrList(categoryId));
    }

}