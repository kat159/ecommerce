package com.ecommerce.product.controller;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.ecommerce.product.dto.ProductDescriptionDto;
import com.ecommerce.product.service.ProductDescriptionService;
import com.ecommerce.product.vo.ProductDescriptionVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("product/productdescription")
@Api(tags="product description, partitioned data, one to one product with primary key mapping to product_id")
public class ProductDescriptionController {
    @Autowired
    private ProductDescriptionService productDescriptionService;

    @GetMapping("page")
    public Result page(@Valid PaginationDto params){
        PageData<ProductDescriptionVo> page = productDescriptionService.page(params);
        return new Result().ok(page);
    }

    @GetMapping("{id}")
    public Result get(@PathVariable("id") Long id){
        ProductDescriptionVo data = productDescriptionService.get(id);
        return new Result().ok(data);
    }

    @PostMapping
    public Result addAll(@RequestBody List<ProductDescriptionDto> dtoList){
        List<Long> res = productDescriptionService.addAll(dtoList);
        return new Result().ok(res);
    }

    @PutMapping
    public Result updateAll(@RequestBody List<ProductDescriptionDto> dtoList){
        productDescriptionService.updateAll(dtoList);
        return new Result();
    }

    @DeleteMapping
    public Result removeAll(@RequestBody List<Long> idList){
        productDescriptionService.removeAll(idList);
        return new Result();
    }
}