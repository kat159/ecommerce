package com.ecommerce.member.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.member.entity.MemberLoginLogEntity;
import com.ecommerce.member.service.MemberLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 会员登录记录
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("member/memberloginlog")
public class MemberLoginLogController {
    @Autowired
    private MemberLoginLogService memberLoginLogService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = memberLoginLogService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        MemberLoginLogEntity memberLoginLog = memberLoginLogService.getById(id);

        return R.ok().put("memberLoginLog", memberLoginLog);
    }

    @PostMapping
        public R save(@RequestBody MemberLoginLogEntity memberLoginLog){

        memberLoginLogService.save(memberLoginLog);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody MemberLoginLogEntity memberLoginLog){
            memberLoginLogService.updateById(memberLoginLog);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            memberLoginLogService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}