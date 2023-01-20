package com.ecommerce.member.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.member.entity.MemberCollectSpuEntity;
import com.ecommerce.member.service.MemberCollectSpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 会员收藏的商品
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("member/membercollectspu")
public class MemberCollectSpuController {
    @Autowired
    private MemberCollectSpuService memberCollectSpuService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = memberCollectSpuService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        MemberCollectSpuEntity memberCollectSpu = memberCollectSpuService.getById(id);

        return R.ok().put("memberCollectSpu", memberCollectSpu);
    }

    @PostMapping
        public R save(@RequestBody MemberCollectSpuEntity memberCollectSpu){

        memberCollectSpuService.save(memberCollectSpu);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody MemberCollectSpuEntity memberCollectSpu){
            memberCollectSpuService.updateById(memberCollectSpu);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            memberCollectSpuService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}