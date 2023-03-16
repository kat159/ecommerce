package com.ecommerce.order.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderSkuDto {
    private Long skuId;
    private String skuName;
    private String skuImg;
    private Long skuQuantity;
    private BigDecimal skuOriginalPrice;
    private BigDecimal skuFinalPrice;
}
