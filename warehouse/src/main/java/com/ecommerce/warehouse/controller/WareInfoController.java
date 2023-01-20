package com.ecommerce.warehouse.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.warehouse.entity.WareInfoEntity;
import com.ecommerce.warehouse.service.WareInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 仓库信息
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-19
 */
@RestController
@RequestMapping("warehouse/wareinfo")
public class WareInfoController {
    @Autowired
    private WareInfoService wareInfoService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = wareInfoService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        WareInfoEntity wareInfo = wareInfoService.getById(id);

        return R.ok().put("wareInfo", wareInfo);
    }

    @PostMapping
        public R save(@RequestBody WareInfoEntity wareInfo){

        wareInfoService.save(wareInfo);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody WareInfoEntity wareInfo){
            wareInfoService.updateById(wareInfo);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            wareInfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}