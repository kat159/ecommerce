package com.ecommerce.order.config;

import com.ecommerce.common.constant.RabbitMQConstant;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;

@Configuration
public class OrderEventMQConfig {

    @Bean
    public Exchange orderServiceTopicExchange() {
        return new TopicExchange(RabbitMQConstant.ORDER_SERVICE_TOPIC_EXCHANGE, true, false);
    }

    @Bean
    public Binding inventoryOrderCreateConfirmBinding() {
        return new Binding(
                RabbitMQConstant.INVENTORY_DEDUCTION_CONFIRM_QUEUE,
                Binding.DestinationType.QUEUE,
                RabbitMQConstant.ORDER_SERVICE_TOPIC_EXCHANGE,
                RabbitMQConstant.ORDER_CREATE_CONFIRM_ROUTING_KEY,
                null);
    }
}
