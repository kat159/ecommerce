package com.ecommerce.product.open_feign;


import com.ecommerce.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ecommerce-order-service")
public interface OrderClient {

    @GetMapping("order/order")
    Result<Object> getOrderByOrderUUID(
            @RequestParam String uuid
    );
}
