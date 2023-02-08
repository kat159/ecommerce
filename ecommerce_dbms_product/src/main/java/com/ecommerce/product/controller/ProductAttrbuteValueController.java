package com.ecommerce.product.controller;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.ecommerce.product.dto.ProductAttrbuteValueDto;
import com.ecommerce.product.service.ProductAttrbuteValueService;
import com.ecommerce.product.vo.ProductAttrbuteValueVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("product/productattrbutevalue")
@Api(tags="product attribute value, many to one product")
public class ProductAttrbuteValueController {
    @Autowired
    private ProductAttrbuteValueService productAttrbuteValueService;

    @GetMapping("page")
    public Result page(@Valid PaginationDto params){
        PageData<ProductAttrbuteValueVo> page = productAttrbuteValueService.page(params);
        return new Result().ok(page);
    }

    @GetMapping("{id}")
    public Result get(@PathVariable("id") Long id){
        ProductAttrbuteValueVo data = productAttrbuteValueService.get(id);
        return new Result().ok(data);
    }

    @PostMapping
    public Result addAll(@RequestBody List<ProductAttrbuteValueDto> dtoList){
        List<Long> res = productAttrbuteValueService.addAll(dtoList);
        return new Result().ok(res);
    }

    @PutMapping
    public Result updateAll(@RequestBody List<ProductAttrbuteValueDto> dtoList){
        productAttrbuteValueService.updateAll(dtoList);
        return new Result();
    }

    @DeleteMapping
    public Result removeAll(@RequestBody List<Long> idList){
        productAttrbuteValueService.removeAll(idList);
        return new Result();
    }
}