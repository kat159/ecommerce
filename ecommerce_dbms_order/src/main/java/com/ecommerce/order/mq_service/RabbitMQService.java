package com.ecommerce.order.mq_service;

import com.ecommerce.order.mq_service.repository.MessageToRetryDao;
import org.springframework.beans.factory.annotation.Autowired;

public interface RabbitMQService {

    void send(String exchange, String routingKey, String message);
    void retry();

}
