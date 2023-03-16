package com.ecommerce.product.open_feign;


import com.ecommerce.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ecommerce-order-service")
public interface OrderClient {

    @GetMapping("order/order/uuid/{uuid}")
    Result<Object> getOrderByOrderUUID(@PathVariable("uuid") String uuid);
}
