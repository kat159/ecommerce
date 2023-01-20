package com.ecommerce.product.controller;

import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.R;
import com.ecommerce.product.entity.CommentReplayEntity;
import com.ecommerce.product.service.CommentReplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 商品评价回复关系
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@RestController
@RequestMapping("product/commentreplay")
public class CommentReplayController {
    @Autowired
    private CommentReplayService commentReplayService;

    @GetMapping("page")
        public R page(@RequestParam Map<String, Object> params){
        PageUtils page = commentReplayService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("{id}")
        public R get(@PathVariable("id") Long id){
        CommentReplayEntity commentReplay = commentReplayService.getById(id);

        return R.ok().put("commentReplay", commentReplay);
    }

    @PostMapping
        public R save(@RequestBody CommentReplayEntity commentReplay){

        commentReplayService.save(commentReplay);

        return R.ok();
    }

    @PutMapping
        public R update(@RequestBody CommentReplayEntity commentReplay){
            commentReplayService.updateById(commentReplay);

        return R.ok();
    }

    @DeleteMapping
        public R delete(@RequestBody Long[] ids){
            commentReplayService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}