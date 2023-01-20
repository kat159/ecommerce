package com.ecommerce.warehouse.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.warehouse.entity.WareOrderTaskDetailEntity;
import com.ecommerce.warehouse.service.WareOrderTaskDetailService;
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
@RequestMapping("warehouse/wareordertaskdetail")
public class WareOrderTaskDetailController {
    @Autowired
    private WareOrderTaskDetailService wareOrderTaskDetailService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = wareOrderTaskDetailService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        WareOrderTaskDetailEntity wareOrderTaskDetail = wareOrderTaskDetailService.getById(id);

        return R.ok().put("wareOrderTaskDetail", wareOrderTaskDetail);
    }

    @PostMapping
        public R save(@RequestBody WareOrderTaskDetailEntity wareOrderTaskDetail){

        wareOrderTaskDetailService.save(wareOrderTaskDetail);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody WareOrderTaskDetailEntity wareOrderTaskDetail){
            wareOrderTaskDetailService.updateById(wareOrderTaskDetail);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            wareOrderTaskDetailService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}