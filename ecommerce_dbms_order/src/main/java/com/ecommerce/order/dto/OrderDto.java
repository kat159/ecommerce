package com.ecommerce.order.dto;


import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderDto {
    private Long id;
    // 1. Pending 2. not pending
    private String uuid;
    private Integer status;
    private String transactionId;
    private Integer isArchived;
    private LocalDateTime createDate;
    private String shippingCompany;
    private String shippingTrackingNumber;
    private Long memberId;
    private String orderUUID;
    private String paymentMethod;
    private String paymentCardNumber;
    private BigDecimal shippingFee;
    private BigDecimal shippingTime;
    private String shippingName;
    private String shippingPhone;
    private String shippingPostcode;
    private String shippingCountry;
    private String shippingState;
    private String shippingCity;
    private String shippingAddress;
    private BigDecimal originalTotalPrice;
    private BigDecimal finalTotalPrice;
    private String note;
}
