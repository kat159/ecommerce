package com.ecommerce.product.config;

import com.ecommerce.common.constant.RabbitMQConstant;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;

@Configuration
public class RabbitMQConfig {
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue inventoryDeductionConfirmQueue() {
        return new Queue(RabbitMQConstant.INVENTORY_DEDUCTION_CONFIRM_QUEUE, true, false, false);
    }
}
