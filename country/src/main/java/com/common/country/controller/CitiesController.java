package com.common.country.controller;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.common.country.dto.CitiesDto;
import com.common.country.service.CitiesService;
import com.common.country.vo.CitiesVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("country/city")
@Api(tags="")
public class CitiesController {
    @Autowired
    private CitiesService citiesService;

    @GetMapping("page")
    public Result page(@Valid PaginationDto params){
        PageData<CitiesVo> page = citiesService.page(params);
        return new Result().ok(page);
    }

    @GetMapping("{id}")
    public Result get(@PathVariable("id") Long id){
        CitiesVo data = citiesService.get(id);
        return new Result().ok(data);
    }

    @PostMapping
    public Result addAll(@RequestBody List<CitiesDto> dtoList){
        List<Long> res = citiesService.addAll(dtoList);
        return new Result().ok(res);
    }

    @PutMapping
    public Result updateAll(@RequestBody List<CitiesDto> dtoList){
        citiesService.updateAll(dtoList);
        return new Result();
    }

    @DeleteMapping
    public Result removeAll(@RequestBody List<Long> idList){
        citiesService.removeAll(idList);
        return new Result();
    }
}