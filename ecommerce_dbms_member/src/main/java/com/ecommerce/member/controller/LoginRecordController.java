package com.ecommerce.member.controller;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.ecommerce.member.dto.LoginRecordDto;
import com.ecommerce.member.service.LoginRecordService;
import com.ecommerce.member.vo.LoginRecordVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("member/loginrecord")
@Api(tags="member login record")
public class LoginRecordController {
    @Autowired
    private LoginRecordService loginRecordService;

    @GetMapping("page")
    public Result page(@Valid PaginationDto params){
        PageData<LoginRecordVo> page = loginRecordService.page(params);
        return new Result().ok(page);
    }

    @GetMapping("{id}")
    public Result get(@PathVariable("id") Long id){
        LoginRecordVo data = loginRecordService.get(id);
        return new Result().ok(data);
    }

    @PostMapping
    public Result addAll(@RequestBody List<LoginRecordDto> dtoList){
        List<Long> res = loginRecordService.addAll(dtoList);
        return new Result().ok(res);
    }

    @PutMapping
    public Result updateAll(@RequestBody List<LoginRecordDto> dtoList){
        loginRecordService.updateAll(dtoList);
        return new Result();
    }

    @DeleteMapping
    public Result removeAll(@RequestBody List<Long> idList){
        loginRecordService.removeAll(idList);
        return new Result();
    }
}