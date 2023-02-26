package com.ecommerce.product.controller;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.ecommerce.product.dto.ProductDto;
import com.ecommerce.product.dto.aggregate.ProductManageDto;
import com.ecommerce.product.dto.aggregate.ProductPublishDto;
import com.ecommerce.product.dto.pagination.ProductPaginationDto;
import com.ecommerce.product.dto.pagination.ProductSearchParams;
import com.ecommerce.product.service.ProductService;
import com.ecommerce.product.vo.ProductVo;
import com.ecommerce.product.vo.aggregate.ProductSearchVo;
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

    @GetMapping("detail/sku/{skuId}")
    public Result getDetailBySkuId(@PathVariable("skuId") Long skuId){
        ProductVo data = productService.getDetailBySkuId(skuId);
        return new Result().ok(data);
    }

    @PostMapping("search")
    public Result search(@Valid @RequestBody ProductSearchParams params){
        PageData<ProductSearchVo> res = productService.search(params);
        // return new Result().ok(page);
        return new Result().ok(res);
    }
    @PostMapping("publish")
    public Result publishAll(@RequestBody List<ProductPublishDto> dtoList){
        List<Long> ids = productService.publishAll(dtoList);
        return new Result().ok(ids);
    }
    @PutMapping("manage")
    public Result manageAll(@Valid @RequestBody List<ProductManageDto> dtoList){
        productService.manageAll(dtoList);
        return new Result();
    }

    @GetMapping("page")
    public Result page(@Valid ProductPaginationDto params){
        // return new Result().ok(params);
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