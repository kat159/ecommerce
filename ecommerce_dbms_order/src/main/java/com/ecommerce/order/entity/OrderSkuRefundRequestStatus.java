package com.ecommerce.order.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Entity
@Data
public class OrderSkuRefundRequestStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long orderSkuId;
    private Long orderSkuRefundRequestId;
    // 0-Under review
    // 1-Approved
    // 2-Waiting for return
    // 3-Return Items Received
    // 4-Refunded
    // 5-Rejected (by admin)
    // 6-Canceled (by user)
    private Integer status;
    private String handlerUsername;
    private String note;
    private LocalDateTime createDate;
}
