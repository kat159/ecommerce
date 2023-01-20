package com.ecommerce.member.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.member.entity.MemberStatisticsInfoEntity;
import com.ecommerce.member.service.MemberStatisticsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 会员统计信息
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("member/memberstatisticsinfo")
public class MemberStatisticsInfoController {
    @Autowired
    private MemberStatisticsInfoService memberStatisticsInfoService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = memberStatisticsInfoService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        MemberStatisticsInfoEntity memberStatisticsInfo = memberStatisticsInfoService.getById(id);

        return R.ok().put("memberStatisticsInfo", memberStatisticsInfo);
    }

    @PostMapping
        public R save(@RequestBody MemberStatisticsInfoEntity memberStatisticsInfo){

        memberStatisticsInfoService.save(memberStatisticsInfo);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody MemberStatisticsInfoEntity memberStatisticsInfo){
            memberStatisticsInfoService.updateById(memberStatisticsInfo);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            memberStatisticsInfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}