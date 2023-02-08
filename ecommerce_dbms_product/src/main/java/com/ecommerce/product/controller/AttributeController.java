package com.ecommerce.product.controller;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.ecommerce.product.dto.AttributeDto;
import com.ecommerce.product.service.AttributeService;
import com.ecommerce.product.vo.AttributeVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("product/attribute")
@Api(tags="product attribute")
public class AttributeController {
    @Autowired
    private AttributeService attributeService;

    @GetMapping("page")
    public Result page(@Valid PaginationDto params){
        PageData<AttributeVo> page = attributeService.page(params);
        return new Result().ok(page);
    }

    @GetMapping("{id}")
    public Result get(@PathVariable("id") Long id){
        AttributeVo data = attributeService.get(id);
        return new Result().ok(data);
    }

    @PostMapping
    public Result addAll(@RequestBody List<AttributeDto> dtoList){
        List<Long> res = attributeService.addAll(dtoList);
        return new Result().ok(res);
    }

    @PutMapping
    public Result updateAll(@RequestBody List<AttributeDto> dtoList){
        attributeService.updateAll(dtoList);
        return new Result();
    }

    @DeleteMapping
    public Result removeAll(@RequestBody List<Long> idList){
        attributeService.removeAll(idList);
        return new Result();
    }
}