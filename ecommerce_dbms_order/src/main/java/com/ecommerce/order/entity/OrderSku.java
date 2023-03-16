package com.ecommerce.order.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;


@Entity
@Data
public class OrderSku {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long orderId;
    private Long skuId;
    private String skuName;
    private String skuImg;
    private Long skuQuantity;
    private BigDecimal skuOriginalPrice;
    private BigDecimal skuFinalPrice;
}
