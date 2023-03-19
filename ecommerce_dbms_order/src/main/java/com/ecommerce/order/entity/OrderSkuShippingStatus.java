package com.ecommerce.order.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
public class OrderSkuShippingStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // 0-Unshipped 1-In transit 2-Delivered
    // return info will be order_sku_refund_request_status
    private Integer status;
    private LocalDateTime createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_sku_id")
    @JsonIgnoreProperties("orderSkuShippingStatus")
    private OrderSku orderSku;
}
