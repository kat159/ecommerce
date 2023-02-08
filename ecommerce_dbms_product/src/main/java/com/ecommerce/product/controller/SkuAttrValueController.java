package com.ecommerce.product.controller;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.ecommerce.product.dto.SkuAttrValueDto;
import com.ecommerce.product.service.SkuAttrValueService;
import com.ecommerce.product.vo.SkuAttrValueVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("product/skuattrvalue")
@Api(tags="sku to attr join table, with redundant sale attributes and values")
public class SkuAttrValueController {
    @Autowired
    private SkuAttrValueService skuAttrValueService;

    @GetMapping("page")
    public Result page(@Valid PaginationDto params){
        PageData<SkuAttrValueVo> page = skuAttrValueService.page(params);
        return new Result().ok(page);
    }

    @GetMapping("{id}")
    public Result get(@PathVariable("id") Long id){
        SkuAttrValueVo data = skuAttrValueService.get(id);
        return new Result().ok(data);
    }

    @PostMapping
    public Result addAll(@RequestBody List<SkuAttrValueDto> dtoList){
        List<Long> res = skuAttrValueService.addAll(dtoList);
        return new Result().ok(res);
    }

    @PutMapping
    public Result updateAll(@RequestBody List<SkuAttrValueDto> dtoList){
        skuAttrValueService.updateAll(dtoList);
        return new Result();
    }

    @DeleteMapping
    public Result removeAll(@RequestBody List<Long> idList){
        skuAttrValueService.removeAll(idList);
        return new Result();
    }
}