package com.ecommerce.member.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.member.entity.MemberReceiveAddressEntity;
import com.ecommerce.member.service.MemberReceiveAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 会员收货地址
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("member/memberreceiveaddress")
public class MemberReceiveAddressController {
    @Autowired
    private MemberReceiveAddressService memberReceiveAddressService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = memberReceiveAddressService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        MemberReceiveAddressEntity memberReceiveAddress = memberReceiveAddressService.getById(id);

        return R.ok().put("memberReceiveAddress", memberReceiveAddress);
    }

    @PostMapping
        public R save(@RequestBody MemberReceiveAddressEntity memberReceiveAddress){

        memberReceiveAddressService.save(memberReceiveAddress);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody MemberReceiveAddressEntity memberReceiveAddress){
            memberReceiveAddressService.updateById(memberReceiveAddress);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            memberReceiveAddressService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}