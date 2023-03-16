package com.ecommerce.order.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Entity
@Data
public class OrderSkuShippingStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long orderSkuId;
    // 0-Unshipped 1-In transit 2-Delivered
    // return info will be order_sku_refund_request_status
    private Integer status;
    private LocalDateTime createDate;
}
