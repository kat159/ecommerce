package com.ecommerce.order.dto;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderSkuRefundRequestDto {
    private String username;
    private BigDecimal refundTotalPrice;
    private BigDecimal refundShippingFee;
    private BigDecimal refundPerSkuPrice;
    private Long refundQuantity;
    private String reason;
    private String description;
    private String proofImages;
}
