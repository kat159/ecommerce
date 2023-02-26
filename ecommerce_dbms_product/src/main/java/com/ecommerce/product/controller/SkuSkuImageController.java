package com.ecommerce.product.controller;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.ecommerce.product.dto.SkuSkuImageDto;
import com.ecommerce.product.service.SkuSkuImageService;
import com.ecommerce.product.vo.SkuSkuImageVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("product/skuskuimage")
@Api(tags="join table")
public class SkuSkuImageController {
    @Autowired
    private SkuSkuImageService skuSkuImageService;

    @GetMapping("page")
    public Result page(@Valid PaginationDto params){
        PageData<SkuSkuImageVo> page = skuSkuImageService.page(params);
        return new Result().ok(page);
    }

    @GetMapping("{id}")
    public Result get(@PathVariable("id") Long id){
        SkuSkuImageVo data = skuSkuImageService.get(id);
        return new Result().ok(data);
    }

    @PostMapping
    public Result addAll(@RequestBody List<SkuSkuImageDto> dtoList){
        List<Long> res = skuSkuImageService.addAll(dtoList);
        return new Result().ok(res);
    }

    @PutMapping
    public Result updateAll(@RequestBody List<SkuSkuImageDto> dtoList){
        skuSkuImageService.updateAll(dtoList);
        return new Result();
    }

    @DeleteMapping
    public Result removeAll(@RequestBody List<Long> idList){
        skuSkuImageService.removeAll(idList);
        return new Result();
    }
}