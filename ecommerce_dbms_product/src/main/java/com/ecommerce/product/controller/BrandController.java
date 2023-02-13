package com.ecommerce.product.controller;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.ecommerce.product.dto.BrandDto;
import com.ecommerce.product.dto.ProductDto;
import com.ecommerce.product.dto.pagination.BrandPaginationDto;
import com.ecommerce.product.entity.CategoryBrandEntity;
import com.ecommerce.product.entity.ProductEntity;
import com.ecommerce.product.service.BrandService;
import com.ecommerce.product.vo.BrandVo;
import com.ecommerce.product.vo.ProductVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("product/brand")
@Api(tags = "brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    // @GetMapping("page")
    // public Result page(@Valid PaginationDto params) {
    //     PageData<BrandVo> page = brandService.page(params);
    //     return new Result().ok(page);
    // }

    @GetMapping("page")
    public Result page(@Valid BrandPaginationDto params) {
        PageData<BrandVo> page = brandService.page(params);
        return new Result().ok(page);
    }

    @GetMapping("{id}/category-brand")
    public Result getAllCategoryBrand(@PathVariable("id") Long brandId) {
        List<CategoryBrandEntity> res = brandService.getAllCategoryBrand(brandId);
        return new Result().ok(res);
    }

    @PostMapping("{id}/category-brand/{cid}")
    public Result addCategoryBrand(@PathVariable("id") Long brandId,
                                   @PathVariable("cid") Long categoryId) {
        List<Long> ids = brandService.addCategoryBrand(brandId, categoryId);
        return new Result().ok(ids);
    }

    @GetMapping("{id}/product")
    public Result getAllProduct(@PathVariable("id") Long brandId) {
        List<ProductVo> productList = brandService.getAllProduct(brandId);
        return new Result().ok(productList);
    }

    @PostMapping({"{id}/product"})
    public Result addAllProduct(@PathVariable("id") Long brandId, @RequestBody List<ProductDto> productDtoList) {
        List<Long> res = brandService.addAllProduct(brandId, productDtoList);
        return new Result().ok(res);
    }


    @GetMapping("{id}")
    public Result get(@PathVariable("id") Long id) {
        BrandVo data = brandService.get(id);
        return new Result().ok(data);
    }

    @PostMapping
    public Result addAll(@RequestBody List<BrandDto> dtoList) {
        List<Long> res = brandService.addAll(dtoList);
        return new Result().ok(res);
    }

    @PutMapping
    public Result updateAll(@RequestBody List<BrandDto> dtoList) {
        brandService.updateAll(dtoList);
        return new Result();
    }

    @DeleteMapping
    public Result removeAll(@RequestBody List<Long> idList) {
        brandService.removeAll(idList);
        return new Result();
    }
}