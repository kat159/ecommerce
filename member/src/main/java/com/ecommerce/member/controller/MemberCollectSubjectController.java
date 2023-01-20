package com.ecommerce.member.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.member.entity.MemberCollectSubjectEntity;
import com.ecommerce.member.service.MemberCollectSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 会员收藏的专题活动
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("member/membercollectsubject")
public class MemberCollectSubjectController {
    @Autowired
    private MemberCollectSubjectService memberCollectSubjectService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = memberCollectSubjectService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        MemberCollectSubjectEntity memberCollectSubject = memberCollectSubjectService.getById(id);

        return R.ok().put("memberCollectSubject", memberCollectSubject);
    }

    @PostMapping
        public R save(@RequestBody MemberCollectSubjectEntity memberCollectSubject){

        memberCollectSubjectService.save(memberCollectSubject);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody MemberCollectSubjectEntity memberCollectSubject){
            memberCollectSubjectService.updateById(memberCollectSubject);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            memberCollectSubjectService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}