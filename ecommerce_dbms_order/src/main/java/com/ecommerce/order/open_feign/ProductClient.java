package com.ecommerce.order.open_feign;


import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.dto.internal_dto.OrderSkuInternalDto;
import com.ecommerce.common.dto.internal_dto.SkuInternalDto;
import com.ecommerce.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ecommerce-product-service")
public interface ProductClient {

    @GetMapping("/product/sku")
    Result<List<SkuInternalDto>> getAll(@RequestParam PaginationDto params); // **NOTE: @RequestParam is required for feign request
    @PutMapping("product/sku/inventory/deduct")
    Result deductInventory(@RequestBody List<OrderSkuInternalDto> orderSkuList);
    @GetMapping("/product/sku/test")
    Result test(@RequestParam PaginationDto params); // **NOTE: must add @RequestParam here to make it as an request param object**
    @PostMapping("/product/sku/test")
    Result test2(PaginationDto params);  // **NOTE: openfeign make it default as @RequestBody**
    @PutMapping("/product/sku/test")
    Result test3(@RequestBody List<OrderSkuInternalDto> list);

}
