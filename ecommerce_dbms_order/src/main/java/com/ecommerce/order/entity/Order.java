package com.ecommerce.order.entity;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "`order`")
@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @PrePersist
    public void prePersist() {
        status = 1;
        isArchived = 0;
        createDate = LocalDateTime.now();
    }
}
