package com.ecommerce.order.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class PlaceOrderDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long memberId;
    private String orderUUID;
    private String paymentMethod;
    private String paymentCardNumber;
    private BigDecimal shippingFee;
    private BigDecimal shippingTime; // seconds
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
    List<OrderSkuDto> skus;
}
