package com.ecommerce.member.controller;

import com.ecommerce.common.constant.Constant;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.ecommerce.member.dto.StatisticsDto;
import com.ecommerce.member.service.StatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;


@RestController
@RequestMapping("member/statistics")
@Api(tags="Partitioned data, aggregated anformation, one to one member")
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("page")
    @ApiOperation("pagination")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "Current page, starting at 1", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "Size per page", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "sort field", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "sort order(asc、desc)", paramType = "query", dataType="String")
    })
    public Result page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<StatisticsDto> page = statisticsService.page(params);

        return new Result().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("get")
    public Result get(@PathVariable("id") Long id){
        StatisticsDto data = statisticsService.get(id);
        return new Result().ok(data);
    }

    @PostMapping
    @ApiOperation("save")
    public Result save(@RequestBody StatisticsDto dto){
        statisticsService.save(dto);
        return new Result();
    }

    @PutMapping
    @ApiOperation("update")
    public Result update(@RequestBody StatisticsDto dto){
        statisticsService.update(dto);
        return new Result();
    }

    @DeleteMapping
    @ApiOperation("delete")
    public Result delete(@RequestBody Long[] ids){
        statisticsService.delete(ids);
        return new Result();
    }
}