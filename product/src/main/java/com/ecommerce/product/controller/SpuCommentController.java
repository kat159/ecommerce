package com.ecommerce.product.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.product.entity.SpuCommentEntity;
import com.ecommerce.product.service.SpuCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 商品评价
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("product/spucomment")
public class SpuCommentController {
    @Autowired
    private SpuCommentService spuCommentService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = spuCommentService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        SpuCommentEntity spuComment = spuCommentService.getById(id);

        return R.ok().put("spuComment", spuComment);
    }

    @PostMapping
        public R save(@RequestBody SpuCommentEntity spuComment){

        spuCommentService.save(spuComment);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody SpuCommentEntity spuComment){
            spuCommentService.updateById(spuComment);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            spuCommentService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}