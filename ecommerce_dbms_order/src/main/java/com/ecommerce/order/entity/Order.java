package com.ecommerce.order.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "`order`")
@Entity
@Getter
@Setter
@DynamicUpdate
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // 1. Pending 2. not pending
    private String uuid;
    private String username;
    public enum Status {    // @TODO: not implemented, currently the order status is init as payment-verified
        PENDING,            // payment success but not verified
        CANCELLED,          // can only be cancelled while pending or all the orderSku are not shipped
        PAYMENT_VERIFIED, PAYMENT_REJECTED,
    }
    @Enumerated(EnumType.STRING)
    private Status status;                        // latest status
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
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // @JsonManagedReference
    @JsonIgnoreProperties("order") // ignore order field when call OrderSku.toString()
    private List<OrderSku> orderSkus;

    @PrePersist
    public void prePersist() {
        isArchived = 0;
        createDate = LocalDateTime.now();
    }
}
