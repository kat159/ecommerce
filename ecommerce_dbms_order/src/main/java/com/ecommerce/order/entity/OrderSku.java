package com.ecommerce.order.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
public class OrderSku {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long skuId;
    private String skuName;
    private String skuImg;
    private Long skuQuantity;
    private BigDecimal skuOriginalPrice;
    private BigDecimal skuFinalPrice;
    private BigDecimal rating;
    /**
     * The following states must occur in chronological order。
     *      a state one a line can only be reached from the state on the immediately preceding line.
     *      States that are not listed cannot occur.
     */
    public enum Status {
        // 1
        NOT_SHIPPED,
        // 2
        // can only be shipped after payment verified(in Order.Status)
        IN_TRANSIT,
        // 3.
        // refund Should not be approved when in transit
        REFUND_WITHOUT_RETURN_REQUESTED_AND_IN_TRANSIT,
        REFUND_WITH_RETURN_REQUESTED_AND_IN_TRANSIT,
        REFUND_WITHOUT_RETURN_REJECTED_AND_IN_TRANSIT,
        REFUND_WITH_RETURN_REJECTED_AND_IN_TRANSIT,
        // 4.
        DELIVERED,
        REFUND_WITHOUT_RETURN_REQUESTED_AND_DELIVERED,
        REFUND_WITH_RETURN_REQUESTED_AND_DELIVERED,
        REFUND_WITHOUT_RETURN_APPROVED_AND_DELIVERED,
        REFUND_WITH_RETURN_APPROVED_AND_DELIVERED,
        REFUND_WITHOUT_RETURN_REJECTED_AND_DELIVERED,
        REFUND_WITH_RETURN_REJECTED_AND_DELIVERED,
    }
// latest data
    @Enumerated(EnumType.STRING)
    private Status status;
    private BigDecimal refundRequestPricePerSku;
    private Long refundRequestQuantity;
    private Long refundRequestId;
    private String refundRequestReason;
    private LocalDateTime refundRequestDate;

    private String refundHandlerUsername;
    private String refundHandlerNote;
    private BigDecimal refundedPricePerSku; // might refund multiple times
    private Long refundedQuantity;  // might refund multiple times
    private LocalDateTime refundHandleDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    // @JsonBackReference
    @JsonIgnoreProperties("orderSku")
    private Order order;

    @OneToMany(mappedBy = "orderSku", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("orderSku")
    private List<OrderSkuRefundRequest> refundRequests;

    @OneToMany(mappedBy = "orderSku", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("orderSku")
    private List<OrderSkuShippingStatus> shippingStatuses;

    @PrePersist
    public void prePersist() {
    }
}
