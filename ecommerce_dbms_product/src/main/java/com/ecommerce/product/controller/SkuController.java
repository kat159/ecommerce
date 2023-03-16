package com.ecommerce.product.controller;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.dto.internal_dto.OrderSkuInternalDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.ecommerce.product.dto.SkuDto;
import com.ecommerce.product.service.SkuService;
import com.ecommerce.product.vo.SkuVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("product/sku")
public class SkuController {
    @Autowired
    private SkuService skuService;

    @GetMapping("page")
    public Result page(@Valid PaginationDto params) {
        PageData<SkuVo> page = skuService.page(params);
        return new Result().ok(page);
    }

    @GetMapping("{id}")
    public Result get(@PathVariable("id") Long id) {
        SkuVo data = skuService.get(id);
        return new Result().ok(data);
    }

    @GetMapping
    public Result getAll(@Valid PaginationDto params) {
        System.out.println("params: " + params);
        List<SkuVo> list = skuService.getAll(params);
        return new Result().ok(list);
    }

    @GetMapping("test")
    public Result test(PaginationDto params) {
        List<SkuVo> list = skuService.getAll(new PaginationDto());
        return new Result().ok(list);
        // return new Result().ok("test");
    }
    @PostMapping("test")
    public Result test2(@RequestBody PaginationDto params) {
        List<SkuVo> list = skuService.getAll(new PaginationDto());
        return new Result().ok(list);
        // return new Result().ok("test");
    }

    @PutMapping("test")
    public Result test3(@RequestBody List<OrderSkuInternalDto> list) {
        return new Result().ok(list);
        // return new Result().ok("test");
    }


    @PutMapping("inventory/deduct")
    public Result deductInventory(@RequestBody List<OrderSkuInternalDto> orderSkuList) {
        System.out.println("orderSkuList: " + orderSkuList);
        skuService.deductInventory(orderSkuList);
        return new Result();
    }


    @PostMapping
    public Result addAll(@RequestBody List<SkuDto> dtoList) {
        List<Long> res = skuService.addAll(dtoList);
        return new Result().ok(res);
    }

    @PutMapping
    public Result updateAll(@RequestBody List<SkuDto> dtoList) {
        skuService.updateAll(dtoList);
        return new Result();
    }

    @DeleteMapping
    public Result removeAll(@RequestBody List<Long> idList) {
        skuService.removeAll(idList);
        return new Result();
    }
}