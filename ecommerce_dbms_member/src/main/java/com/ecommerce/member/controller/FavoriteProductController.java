package com.ecommerce.member.controller;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.ecommerce.member.dto.FavoriteProductDto;
import com.ecommerce.member.service.FavoriteProductService;
import com.ecommerce.member.vo.FavoriteProductVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("member/favoriteproduct")
@Api(tags="member favorite_product")
public class FavoriteProductController {
    @Autowired
    private FavoriteProductService favoriteProductService;

    @GetMapping("page")
    public Result page(@Valid PaginationDto params){
        PageData<FavoriteProductVo> page = favoriteProductService.page(params);
        return new Result().ok(page);
    }

    @GetMapping("{id}")
    public Result get(@PathVariable("id") Long id){
        FavoriteProductVo data = favoriteProductService.get(id);
        return new Result().ok(data);
    }

    @PostMapping
    public Result addAll(@RequestBody List<FavoriteProductDto> dtoList){
        List<Long> res = favoriteProductService.addAll(dtoList);
        return new Result().ok(res);
    }

    @PutMapping
    public Result updateAll(@RequestBody List<FavoriteProductDto> dtoList){
        favoriteProductService.updateAll(dtoList);
        return new Result();
    }

    @DeleteMapping
    public Result removeAll(@RequestBody List<Long> idList){
        favoriteProductService.removeAll(idList);
        return new Result();
    }
}