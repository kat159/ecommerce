package com.ecommerce.order.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Data
public class OrderSkuRefundRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private BigDecimal refundPerSkuPrice;
    private Long refundQuantity;
    private BigDecimal refundShippingFee;
    private String reason;
    private String description;
    private String proofImages;
    private LocalDateTime createDate;

    public enum Status {
        UNDER_REVIEW,
        APPROVED,
        REJECTED
    }
    @Enumerated(EnumType.STRING)
    private Status status;
    private String handlerUsername;
    private LocalDateTime handleDate;
    private String handleReason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_sku_id")
    @JsonIgnoreProperties("orderSkuRefundRequest")
    private OrderSku orderSku;

    @PrePersist
    public void prePersist() {
        this.createDate = LocalDateTime.now();
    }
}
