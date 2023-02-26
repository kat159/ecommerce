package com.ecommerce.product.controller;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.ecommerce.product.dto.SkuAttributeValueDto;
import com.ecommerce.product.service.SkuAttributeValueService;
import com.ecommerce.product.vo.SkuAttributeValueVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("product/skuattributevalue")
@Api(tags="")
public class SkuAttributeValueController {
    @Autowired
    private SkuAttributeValueService skuAttributeValueService;

    @GetMapping("page")
    public Result page(@Valid PaginationDto params){
        PageData<SkuAttributeValueVo> page = skuAttributeValueService.page(params);
        return new Result().ok(page);
    }

    @GetMapping("{id}")
    public Result get(@PathVariable("id") Long id){
        SkuAttributeValueVo data = skuAttributeValueService.get(id);
        return new Result().ok(data);
    }

    @PostMapping
    public Result addAll(@RequestBody List<SkuAttributeValueDto> dtoList){
        List<Long> res = skuAttributeValueService.addAll(dtoList);
        return new Result().ok(res);
    }

    @PutMapping
    public Result updateAll(@RequestBody List<SkuAttributeValueDto> dtoList){
        skuAttributeValueService.updateAll(dtoList);
        return new Result();
    }

    @DeleteMapping
    public Result removeAll(@RequestBody List<Long> idList){
        skuAttributeValueService.removeAll(idList);
        return new Result();
    }
}