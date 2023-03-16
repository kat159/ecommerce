package com.common.country.controller;

import com.common.country.vo.StatesVo;
import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.common.country.dto.CountriesDto;
import com.common.country.service.CountriesService;
import com.common.country.vo.CountriesVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("country/country")
@Api(tags="")
public class CountriesController {
    @Autowired
    private CountriesService countriesService;

    @GetMapping("all")
    public Result getAll(@RequestParam(value="include", required=false) List<String> include){
        List<CountriesVo> list = countriesService.getAll(include);
        return new Result().ok(list);
    }
    @GetMapping("{id}/state")
    public Result getAllStates(@PathVariable("id") Long id){
        List<StatesVo> list = countriesService.getAllStates(id);
        return new Result().ok(list);
    }
    @GetMapping("page")
    public Result page(@Valid PaginationDto params){
        PageData<CountriesVo> page = countriesService.page(params);
        return new Result().ok(page);
    }

    @GetMapping("{id}")
    public Result get(@PathVariable("id") Long id){
        CountriesVo data = countriesService.get(id);
        return new Result().ok(data);
    }

    @PostMapping
    public Result addAll(@RequestBody List<CountriesDto> dtoList){
        List<Long> res = countriesService.addAll(dtoList);
        return new Result().ok(res);
    }

    @PutMapping
    public Result updateAll(@RequestBody List<CountriesDto> dtoList){
        countriesService.updateAll(dtoList);
        return new Result();
    }

    @DeleteMapping
    public Result removeAll(@RequestBody List<Long> idList){
        countriesService.removeAll(idList);
        return new Result();
    }
}