package com.ecommerce.member.controller;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.ecommerce.member.dto.MemberSkuViewRecordDto;
import com.ecommerce.member.service.MemberSkuViewRecordService;
import com.ecommerce.member.vo.MemberSkuViewRecordVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("member/memberskuviewrecord")
@Api(tags="sku view record")
public class MemberSkuViewRecordController {
    @Autowired
    private MemberSkuViewRecordService memberSkuViewRecordService;

    @GetMapping("page")
    public Result page(@Valid PaginationDto params){
        PageData<MemberSkuViewRecordVo> page = memberSkuViewRecordService.page(params);
        return new Result().ok(page);
    }

    @GetMapping("{id}")
    public Result get(@PathVariable("id") Long id){
        MemberSkuViewRecordVo data = memberSkuViewRecordService.get(id);
        return new Result().ok(data);
    }

    @PostMapping
    public Result addAll(@RequestBody List<MemberSkuViewRecordDto> dtoList){
        List<Long> res = memberSkuViewRecordService.addAll(dtoList);
        return new Result().ok(res);
    }

    @PutMapping
    public Result updateAll(@RequestBody List<MemberSkuViewRecordDto> dtoList){
        memberSkuViewRecordService.updateAll(dtoList);
        return new Result();
    }

    @DeleteMapping
    public Result removeAll(@RequestBody List<Long> idList){
        memberSkuViewRecordService.removeAll(idList);
        return new Result();
    }
}