package com.ecommerce.member.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.member.entity.MemberLevelEntity;
import com.ecommerce.member.service.MemberLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 会员等级
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("member/memberlevel")
public class MemberLevelController {
    @Autowired
    private MemberLevelService memberLevelService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = memberLevelService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        MemberLevelEntity memberLevel = memberLevelService.getById(id);

        return R.ok().put("memberLevel", memberLevel);
    }

    @PostMapping
        public R save(@RequestBody MemberLevelEntity memberLevel){

        memberLevelService.save(memberLevel);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody MemberLevelEntity memberLevel){
            memberLevelService.updateById(memberLevel);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            memberLevelService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}