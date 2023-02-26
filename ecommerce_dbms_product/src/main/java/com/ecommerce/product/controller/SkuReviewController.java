package com.ecommerce.product.controller;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.ecommerce.product.dto.SkuReviewDto;
import com.ecommerce.product.service.SkuReviewService;
import com.ecommerce.product.vo.SkuReviewVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("product/skureview")
@Api(tags="sku review")
public class SkuReviewController {
    @Autowired
    private SkuReviewService skuReviewService;

    @GetMapping("page")
    public Result page(@Valid PaginationDto params){
        PageData<SkuReviewVo> page = skuReviewService.page(params);
        return new Result().ok(page);
    }

    @GetMapping("{id}")
    public Result get(@PathVariable("id") Long id){
        SkuReviewVo data = skuReviewService.get(id);
        return new Result().ok(data);
    }

    @PostMapping
    public Result addAll(@RequestBody List<SkuReviewDto> dtoList){
        List<Long> res = skuReviewService.addAll(dtoList);
        return new Result().ok(res);
    }

    @PutMapping
    public Result updateAll(@RequestBody List<SkuReviewDto> dtoList){
        skuReviewService.updateAll(dtoList);
        return new Result();
    }

    @DeleteMapping
    public Result removeAll(@RequestBody List<Long> idList){
        skuReviewService.removeAll(idList);
        return new Result();
    }
}