package com.ecommerce.member.controller;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.ecommerce.member.dto.MembershipTypeDto;
import com.ecommerce.member.service.MembershipTypeService;
import com.ecommerce.member.vo.MembershipTypeVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("member/membershiptype")
@Api(tags="like 'prime', 'prime pro'")
public class MembershipTypeController {
    @Autowired
    private MembershipTypeService membershipTypeService;

    @GetMapping("page")
    public Result page(@Valid PaginationDto params){
        PageData<MembershipTypeVo> page = membershipTypeService.page(params);
        return new Result().ok(page);
    }

    @GetMapping("{id}")
    public Result get(@PathVariable("id") Long id){
        MembershipTypeVo data = membershipTypeService.get(id);
        return new Result().ok(data);
    }

    @PostMapping
    public Result addAll(@RequestBody List<MembershipTypeDto> dtoList){
        List<Long> res = membershipTypeService.addAll(dtoList);
        return new Result().ok(res);
    }

    @PutMapping
    public Result updateAll(@RequestBody List<MembershipTypeDto> dtoList){
        membershipTypeService.updateAll(dtoList);
        return new Result();
    }

    @DeleteMapping
    public Result removeAll(@RequestBody List<Long> idList){
        membershipTypeService.removeAll(idList);
        return new Result();
    }
}