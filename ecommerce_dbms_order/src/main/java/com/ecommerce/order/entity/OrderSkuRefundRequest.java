package com.ecommerce.order.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Data
public class OrderSkuRefundRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long orderSkuId;
    private LocalDateTime createDate;
    private String username;
    private BigDecimal refundTotalPrice;
    private BigDecimal refundShippingFee;
    private BigDecimal refundPerSkuPrice;
    private Long refundQuantity;
    private String reason;
    private String description;
    private String proofImages;
}
