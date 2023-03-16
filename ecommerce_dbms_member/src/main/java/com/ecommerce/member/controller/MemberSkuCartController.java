package com.ecommerce.member.controller;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.ecommerce.member.dto.MemberSkuCartDto;
import com.ecommerce.member.service.MemberSkuCartService;
import com.ecommerce.member.vo.MemberSkuCartVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("member/memberskucart")
@Api(tags="")
public class MemberSkuCartController {
    @Autowired
    private MemberSkuCartService memberSkuCartService;

    @GetMapping("page")
    public Result page(@Valid PaginationDto params){
        PageData<MemberSkuCartVo> page = memberSkuCartService.page(params);
        return new Result().ok(page);
    }

    @GetMapping("{id}")
    public Result get(@PathVariable("id") Long id){
        MemberSkuCartVo data = memberSkuCartService.get(id);
        return new Result().ok(data);
    }

    @PostMapping
    public Result addAll(@RequestBody List<MemberSkuCartDto> dtoList){
        List<Long> res = memberSkuCartService.addAll(dtoList);
        return new Result().ok(res);
    }

    @PutMapping
    public Result updateAll(@RequestBody List<MemberSkuCartDto> dtoList){
        memberSkuCartService.updateAll(dtoList);
        return new Result();
    }

    @DeleteMapping
    public Result removeAll(@RequestBody List<Long> idList){
        memberSkuCartService.removeAll(idList);
        return new Result();
    }
}