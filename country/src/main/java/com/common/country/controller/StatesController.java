package com.common.country.controller;

import com.common.country.vo.CitiesVo;
import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.common.country.dto.StatesDto;
import com.common.country.service.StatesService;
import com.common.country.vo.StatesVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("country/state")
@Api(tags="")
public class StatesController {
    @Autowired
    private StatesService statesService;

    @GetMapping("{id}/city")
    public Result getAllCities(@PathVariable("id") Long id){
        List<CitiesVo> data = statesService.getAllCities(id);
        return new Result().ok(data);
    }

    @GetMapping("page")
    public Result page(@Valid PaginationDto params){
        PageData<StatesVo> page = statesService.page(params);
        return new Result().ok(page);
    }

    @GetMapping("{id}")
    public Result get(@PathVariable("id") Long id){
        StatesVo data = statesService.get(id);
        return new Result().ok(data);
    }

    @PostMapping
    public Result addAll(@RequestBody List<StatesDto> dtoList){
        List<Long> res = statesService.addAll(dtoList);
        return new Result().ok(res);
    }

    @PutMapping
    public Result updateAll(@RequestBody List<StatesDto> dtoList){
        statesService.updateAll(dtoList);
        return new Result();
    }

    @DeleteMapping
    public Result removeAll(@RequestBody List<Long> idList){
        statesService.removeAll(idList);
        return new Result();
    }
}