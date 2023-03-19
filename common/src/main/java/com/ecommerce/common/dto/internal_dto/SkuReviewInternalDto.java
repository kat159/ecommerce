package com.ecommerce.common.dto.internal_dto;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class SkuReviewInternalDto {
    private Long skuId;
    private BigDecimal rating;
}
