package com.ecommerce.member.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.member.entity.GrowthChangeHistoryEntity;
import com.ecommerce.member.service.GrowthChangeHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 成长值变化历史记录
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("member/growthchangehistory")
public class GrowthChangeHistoryController {
    @Autowired
    private GrowthChangeHistoryService growthChangeHistoryService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = growthChangeHistoryService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        GrowthChangeHistoryEntity growthChangeHistory = growthChangeHistoryService.getById(id);

        return R.ok().put("growthChangeHistory", growthChangeHistory);
    }

    @PostMapping
        public R save(@RequestBody GrowthChangeHistoryEntity growthChangeHistory){

        growthChangeHistoryService.save(growthChangeHistory);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody GrowthChangeHistoryEntity growthChangeHistory){
            growthChangeHistoryService.updateById(growthChangeHistory);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            growthChangeHistoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}