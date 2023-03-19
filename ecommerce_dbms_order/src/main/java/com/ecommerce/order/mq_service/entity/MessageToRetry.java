package com.ecommerce.order.mq_service.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class MessageToRetry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String message;
    private String exchange;
    private String routingKey;
    private Integer retryCount = 0;
    private LocalDateTime createDate = LocalDateTime.now();
    public MessageToRetry() {
    }
    public MessageToRetry(String exchange, String routingKey, String message) {
        this.message = message;
        this.exchange = exchange;
        this.routingKey = routingKey;
    }
}
