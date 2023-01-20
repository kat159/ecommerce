package com.ecommerce.member.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.member.entity.IntegrationChangeHistoryEntity;
import com.ecommerce.member.service.IntegrationChangeHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 积分变化历史记录
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("member/integrationchangehistory")
public class IntegrationChangeHistoryController {
    @Autowired
    private IntegrationChangeHistoryService integrationChangeHistoryService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = integrationChangeHistoryService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        IntegrationChangeHistoryEntity integrationChangeHistory = integrationChangeHistoryService.getById(id);

        return R.ok().put("integrationChangeHistory", integrationChangeHistory);
    }

    @PostMapping
        public R save(@RequestBody IntegrationChangeHistoryEntity integrationChangeHistory){

        integrationChangeHistoryService.save(integrationChangeHistory);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody IntegrationChangeHistoryEntity integrationChangeHistory){
            integrationChangeHistoryService.updateById(integrationChangeHistory);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            integrationChangeHistoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}