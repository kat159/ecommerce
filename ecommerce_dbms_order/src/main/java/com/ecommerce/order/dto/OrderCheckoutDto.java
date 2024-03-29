package com.ecommerce.order.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderCheckoutDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long memberId;
    List<OrderSkuDto> skus;

}
