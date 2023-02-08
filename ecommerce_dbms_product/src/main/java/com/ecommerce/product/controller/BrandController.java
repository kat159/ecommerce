package com.ecommerce.product.controller;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.ecommerce.product.dto.BrandDto;
import com.ecommerce.product.service.BrandService;
import com.ecommerce.product.vo.BrandVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("product/brand")
@Api(tags="brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping("page")
    public Result page(@Valid PaginationDto params){
        PageData<BrandVo> page = brandService.page(params);
        return new Result().ok(page);
    }

    @GetMapping("{id}")
    public Result get(@PathVariable("id") Long id){
        BrandVo data = brandService.get(id);
        return new Result().ok(data);
    }

    @PostMapping
    public Result addAll(@RequestBody List<BrandDto> dtoList){
        List<Long> res = brandService.addAll(dtoList);
        return new Result().ok(res);
    }

    @PutMapping
    public Result updateAll(@RequestBody List<BrandDto> dtoList){
        brandService.updateAll(dtoList);
        return new Result();
    }

    @DeleteMapping
    public Result removeAll(@RequestBody List<Long> idList){
        brandService.removeAll(idList);
        return new Result();
    }
}