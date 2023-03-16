package com.ecommerce.member.controller;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.ecommerce.member.dto.MemberDto;
import com.ecommerce.member.dto.MemberSkuCartDto;
import com.ecommerce.member.dto.MemberSkuViewRecordDto;
import com.ecommerce.member.dto.ReceivingAddressDto;
import com.ecommerce.member.service.MemberService;
import com.ecommerce.member.vo.MemberSkuCartVo;
import com.ecommerce.member.vo.MemberSkuViewRecordVo;
import com.ecommerce.member.vo.MemberVo;
import com.ecommerce.member.vo.ReceivingAddressVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("member/member")
@Api(tags="member information")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("login")
    @ApiOperation(value = "user should login on keycloak page, " +
            "then send token to this api to get user info or register a ecommerce account if first time use this app.")
    public Result login(@RequestParam Optional<String> token, @RequestBody MemberDto dto){
        System.out.println("token: " + token);
        System.out.println("dto: " + dto);
        MemberVo data = memberService.login(dto, token.orElse(""));
        return new Result().ok(data);
    }
    @GetMapping("{username}/cart")
    public Result pageCart(@PathVariable("username") String username, PaginationDto params){
        PageData<MemberSkuCartVo> page = memberService.pageCart(username, params);
        return new Result().ok(page);
    }
    @PostMapping("{username}/cart")
    public Result addToCart(@PathVariable("username") String username, @RequestBody List<MemberSkuCartDto> cartDtoList){
        memberService.addToCart(username, cartDtoList);
        return new Result();
    }

    @GetMapping("{username}/address")
    public Result pageAddress(@PathVariable("username") String username, PaginationDto params){
        PageData<ReceivingAddressVo> page = memberService.pageAddress(username, params);
        return new Result().ok(page);
    }

    @PostMapping("{username}/address")
    public Result addAddress(@PathVariable("username") String username, @RequestBody List<ReceivingAddressDto> dtoList){
        memberService.addAddress(username, dtoList);
        return new Result();
    }

    @GetMapping("{username}/browse-history")
    public Result pageBrowseHistory(@PathVariable("username") String username, PaginationDto params){
        PageData<MemberSkuViewRecordVo> page = memberService.pageBrowseHistory(username, params);
        return new Result().ok(page);
    }

    @PostMapping("{username}/browse-history")
    public Result addToBrowseHistory(@PathVariable("username") String username, @RequestBody List<MemberSkuViewRecordDto> dtoList){
        memberService.addToBrowseHistory(username, dtoList);
        return new Result();
    }

    @GetMapping("page")
    public Result page(@Valid PaginationDto params){
        PageData<MemberVo> page = memberService.page(params);
        return new Result().ok(page);
    }

    @GetMapping("{id}")
    public Result get(@PathVariable("id") Long id){
        MemberVo data = memberService.get(id);
        return new Result().ok(data);
    }

    // @PostMapping
    // public Result addAll(@RequestBody List<MemberDto> dtoList){
    //     List<Long> res = memberService.addAll(dtoList);
    //     return new Result().ok(res);
    // }

    @PutMapping
    public Result updateAll(@RequestBody List<MemberDto> dtoList){
        System.out.println("dtoList: " + dtoList);
        memberService.updateAll(dtoList);
        return new Result();
    }

    @DeleteMapping
    public Result removeAll(@RequestBody List<Long> idList){
        memberService.removeAll(idList);
        return new Result();
    }
}