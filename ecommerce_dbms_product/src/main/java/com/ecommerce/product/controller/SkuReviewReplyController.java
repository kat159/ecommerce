package com.ecommerce.product.controller;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.ecommerce.product.dto.SkuReviewReplyDto;
import com.ecommerce.product.service.SkuReviewReplyService;
import com.ecommerce.product.vo.SkuReviewReplyVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("product/skureviewreply")
@Api(tags="")
public class SkuReviewReplyController {
    @Autowired
    private SkuReviewReplyService skuReviewReplyService;

    @GetMapping("page")
    public Result page(@Valid PaginationDto params){
        PageData<SkuReviewReplyVo> page = skuReviewReplyService.page(params);
        return new Result().ok(page);
    }

    @GetMapping("{id}")
    public Result get(@PathVariable("id") Long id){
        SkuReviewReplyVo data = skuReviewReplyService.get(id);
        return new Result().ok(data);
    }

    @PostMapping
    public Result addAll(@RequestBody List<SkuReviewReplyDto> dtoList){
        List<Long> res = skuReviewReplyService.addAll(dtoList);
        return new Result().ok(res);
    }

    @PutMapping
    public Result updateAll(@RequestBody List<SkuReviewReplyDto> dtoList){
        skuReviewReplyService.updateAll(dtoList);
        return new Result();
    }

    @DeleteMapping
    public Result removeAll(@RequestBody List<Long> idList){
        skuReviewReplyService.removeAll(idList);
        return new Result();
    }
}