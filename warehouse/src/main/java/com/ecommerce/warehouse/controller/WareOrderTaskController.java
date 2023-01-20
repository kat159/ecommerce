package com.ecommerce.warehouse.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.warehouse.entity.WareOrderTaskEntity;
import com.ecommerce.warehouse.service.WareOrderTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 库存工作单
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-19
 */
@RestController
@RequestMapping("warehouse/wareordertask")
public class WareOrderTaskController {
    @Autowired
    private WareOrderTaskService wareOrderTaskService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = wareOrderTaskService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        WareOrderTaskEntity wareOrderTask = wareOrderTaskService.getById(id);

        return R.ok().put("wareOrderTask", wareOrderTask);
    }

    @PostMapping
        public R save(@RequestBody WareOrderTaskEntity wareOrderTask){

        wareOrderTaskService.save(wareOrderTask);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody WareOrderTaskEntity wareOrderTask){
            wareOrderTaskService.updateById(wareOrderTask);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            wareOrderTaskService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}