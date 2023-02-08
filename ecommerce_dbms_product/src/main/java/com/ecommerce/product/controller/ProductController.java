package com.ecommerce.product.controller;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.ecommerce.product.dto.ProductDto;
import com.ecommerce.product.service.ProductService;
import com.ecommerce.product.vo.ProductVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("product/product")
@Api(tags="product information")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("page")
    public Result page(@Valid PaginationDto params){
        PageData<ProductVo> page = productService.page(params);
        return new Result().ok(page);
    }

    @GetMapping("{id}")
    public Result get(@PathVariable("id") Long id){
        ProductVo data = productService.get(id);
        return new Result().ok(data);
    }

    @PostMapping
    public Result addAll(@RequestBody List<ProductDto> dtoList){
        List<Long> res = productService.addAll(dtoList);
        return new Result().ok(res);
    }

    @PutMapping
    public Result updateAll(@RequestBody List<ProductDto> dtoList){
        productService.updateAll(dtoList);
        return new Result();
    }

    @DeleteMapping
    public Result removeAll(@RequestBody List<Long> idList){
        productService.removeAll(idList);
        return new Result();
    }
}