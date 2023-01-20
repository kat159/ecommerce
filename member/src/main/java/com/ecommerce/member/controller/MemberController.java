package com.ecommerce.member.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.member.entity.MemberEntity;
import com.ecommerce.member.feign.CouponFeignService;
import com.ecommerce.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 会员
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("member/member")
public class MemberController {
    @Autowired
    private MemberService memberService;


    @Autowired
    private CouponFeignService couponFeignService;

    // test url: http://localhost:8000/member/member/coupons/test
    @GetMapping("coupons/test")
    public R test(){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setNickname("allen");

        R memberCoupons = couponFeignService.memberCoupons();
        return R.ok().put("member", memberEntity).put("coupons", memberCoupons.get("coupons"));
    }

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = memberService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        MemberEntity member = memberService.getById(id);

        return R.ok().put("member", member);
    }

    @PostMapping
        public R save(@RequestBody MemberEntity member){

        memberService.save(member);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody MemberEntity member){
            memberService.updateById(member);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            memberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}