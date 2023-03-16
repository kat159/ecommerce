package com.ecommerce.member.controller;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.ecommerce.member.dto.ReceivingAddressDto;
import com.ecommerce.member.service.ReceivingAddressService;
import com.ecommerce.member.vo.ReceivingAddressVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("member/receivingaddress")
@Api(tags="Member Receive Address")
public class ReceivingAddressController {
    @Autowired
    private ReceivingAddressService receivingAddressService;

    @GetMapping("page")
    public Result page(@Valid PaginationDto params){
        PageData<ReceivingAddressVo> page = receivingAddressService.page(params);
        return new Result().ok(page);
    }

    @GetMapping("{id}")
    public Result get(@PathVariable("id") Long id){
        ReceivingAddressVo data = receivingAddressService.get(id);
        return new Result().ok(data);
    }

    @PostMapping
    public Result addAll(@RequestBody List<ReceivingAddressDto> dtoList){
        List<Long> res = receivingAddressService.addAll(dtoList);
        return new Result().ok(res);
    }

    @PutMapping
    public Result updateAll(@RequestBody List<ReceivingAddressDto> dtoList){
        receivingAddressService.updateAll(dtoList);
        return new Result();
    }

    @DeleteMapping
    public Result removeAll(@RequestBody List<Long> idList){
        receivingAddressService.removeAll(idList);
        return new Result();
    }
}