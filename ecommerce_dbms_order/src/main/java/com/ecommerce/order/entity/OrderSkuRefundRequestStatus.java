package com.ecommerce.order.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
public class OrderSkuRefundRequestStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public enum Status {
        UNDER_REVIEW,
        APPROVED,
        WAITING_FOR_RETURN,
        RETURN_ITEMS_RECEIVED,
        REFUNDED,
        REJECTED,
        CANCELED
    }

    @Enumerated(EnumType.STRING)
    private Status status;

    private String handlerUsername;
    private String note;
    private LocalDateTime createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_sku_refund_request_id")
    @JsonIgnoreProperties("orderSkuRefundRequestStatus")
    private OrderSkuRefundRequest orderSkuRefundRequest;
}
