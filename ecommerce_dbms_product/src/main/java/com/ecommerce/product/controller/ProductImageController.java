package com.ecommerce.product.controller;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.ecommerce.product.dto.ProductImageDto;
import com.ecommerce.product.service.ProductImageService;
import com.ecommerce.product.vo.ProductImageVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("product/productimage")
@Api(tags="product images")
public class ProductImageController {
    @Autowired
    private ProductImageService productImageService;

    @GetMapping("page")
    public Result page(@Valid PaginationDto params){
        PageData<ProductImageVo> page = productImageService.page(params);
        return new Result().ok(page);
    }

    @GetMapping("{id}")
    public Result get(@PathVariable("id") Long id){
        ProductImageVo data = productImageService.get(id);
        return new Result().ok(data);
    }

    @PostMapping
    public Result addAll(@RequestBody List<ProductImageDto> dtoList){
        List<Long> res = productImageService.addAll(dtoList);
        return new Result().ok(res);
    }

    @PutMapping
    public Result updateAll(@RequestBody List<ProductImageDto> dtoList){
        productImageService.updateAll(dtoList);
        return new Result();
    }

    @DeleteMapping
    public Result removeAll(@RequestBody List<Long> idList){
        productImageService.removeAll(idList);
        return new Result();
    }
}