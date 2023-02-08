package com.ecommerce.product.controller;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.ecommerce.product.dto.ProductReviewDto;
import com.ecommerce.product.service.ProductReviewService;
import com.ecommerce.product.vo.ProductReviewVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("product/productreview")
@Api(tags="product review")
public class ProductReviewController {
    @Autowired
    private ProductReviewService productReviewService;

    @GetMapping("page")
    public Result page(@Valid PaginationDto params){
        PageData<ProductReviewVo> page = productReviewService.page(params);
        return new Result().ok(page);
    }

    @GetMapping("{id}")
    public Result get(@PathVariable("id") Long id){
        ProductReviewVo data = productReviewService.get(id);
        return new Result().ok(data);
    }

    @PostMapping
    public Result addAll(@RequestBody List<ProductReviewDto> dtoList){
        List<Long> res = productReviewService.addAll(dtoList);
        return new Result().ok(res);
    }

    @PutMapping
    public Result updateAll(@RequestBody List<ProductReviewDto> dtoList){
        productReviewService.updateAll(dtoList);
        return new Result();
    }

    @DeleteMapping
    public Result removeAll(@RequestBody List<Long> idList){
        productReviewService.removeAll(idList);
        return new Result();
    }
}