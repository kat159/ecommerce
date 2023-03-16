package com.ecommerce.common.dto.internal_dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SkuInternalDto {
    private Long id;
    private BigDecimal price;
    private Long saleCount;
    private BigDecimal primeDiscount;
    private BigDecimal giftCardBonus;
    private BigDecimal finalPrice;
    private Long stock;
}
