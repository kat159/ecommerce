package com.ecommerce.product.controller;

import com.ecommerce.common.constant.Constant;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.ecommerce.product.dto.AttributeDto;
import com.ecommerce.product.vo.AttributeGroupVo;
import com.ecommerce.product.dto.AttributeGroupDto;
import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.product.service.AttributeGroupService;
import com.ecommerce.product.vo.AttributeVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("product/attributegroup")
@Api(tags = "attribute group")
public class AttributeGroupController {
    @Autowired
    private AttributeGroupService attributeGroupService;

    @GetMapping("page")
    public Result page(@Valid PaginationDto params) {
        PageData<AttributeGroupVo> page = attributeGroupService.page(params);
        return new Result().ok(page);
    }

    @GetMapping("{id}")
    public Result get(@PathVariable("id") Long id) {
        AttributeGroupVo data = attributeGroupService.get(id);
        return new Result().ok(data);
    }

    @PostMapping
    public Result addAll(@RequestBody List<AttributeGroupDto> dtoList) {
        List<Long> res = attributeGroupService.addAll(dtoList);
        return new Result().ok(res);
    }

    @PutMapping
    public Result updateAll(@RequestBody List<AttributeGroupDto> dtoList) {
        attributeGroupService.updateAll(dtoList);
        return new Result();
    }

    @DeleteMapping
    public Result removeAll(@RequestBody List<Long> idList) {
        attributeGroupService.removeAll(idList);
        return new Result();
    }

    /**
     * Relational : One to Many Attributes
     */
    @GetMapping("/{id}/attribute")
    public Result getAllAttribute(@PathVariable("id") Long id, @Valid PaginationDto params) {
        List<AttributeVo> list = attributeGroupService.getAllAttribute(id, params);
        return new Result().ok(list);
    }

    @PostMapping("/{id}/attribute")
    public Result addAllAttribute(@PathVariable("id") Long id, @RequestBody List<AttributeDto> dtoList) {
        List<Long> res = attributeGroupService.addAllAttribute(id, dtoList);
        return new Result().ok(res);
    }
}