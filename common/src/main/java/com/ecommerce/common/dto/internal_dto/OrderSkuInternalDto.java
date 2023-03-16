package com.ecommerce.common.dto.internal_dto;

import lombok.Data;

@Data
public class OrderSkuInternalDto {
    private Long orderId;
    private String orderUUID;
    private Long skuId;
    private Long quantity;
}
