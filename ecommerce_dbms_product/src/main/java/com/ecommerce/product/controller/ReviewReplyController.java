package com.ecommerce.product.controller;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.ecommerce.product.dto.ReviewReplyDto;
import com.ecommerce.product.service.ReviewReplyService;
import com.ecommerce.product.vo.ReviewReplyVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("product/reviewreply")
@Api(tags="join table")
public class ReviewReplyController {
    @Autowired
    private ReviewReplyService reviewReplyService;

    @GetMapping("page")
    public Result page(@Valid PaginationDto params){
        PageData<ReviewReplyVo> page = reviewReplyService.page(params);
        return new Result().ok(page);
    }

    @GetMapping("{id}")
    public Result get(@PathVariable("id") Long id){
        ReviewReplyVo data = reviewReplyService.get(id);
        return new Result().ok(data);
    }

    @PostMapping
    public Result addAll(@RequestBody List<ReviewReplyDto> dtoList){
        List<Long> res = reviewReplyService.addAll(dtoList);
        return new Result().ok(res);
    }

    @PutMapping
    public Result updateAll(@RequestBody List<ReviewReplyDto> dtoList){
        reviewReplyService.updateAll(dtoList);
        return new Result();
    }

    @DeleteMapping
    public Result removeAll(@RequestBody List<Long> idList){
        reviewReplyService.removeAll(idList);
        return new Result();
    }
}