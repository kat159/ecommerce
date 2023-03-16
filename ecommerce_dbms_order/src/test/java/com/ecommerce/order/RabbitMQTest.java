package com.ecommerce.order;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RabbitMQTest {

    @Autowired
    AmqpAdmin amqpAdmin;
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void createExchange() {
        DirectExchange directExchange =
                new DirectExchange("ecommerce-order-event-exchange", true, false);
        amqpAdmin.declareExchange(directExchange);
        log.info("directExchange: {}", directExchange);
    }

    @Test
    public void createQueue() {
        Queue queue = new Queue("ecommerce-order-event-queue", true, false, false);
        amqpAdmin.declareQueue(queue);
        log.info("queue: {}", queue);
    }

    @Test
    public void createBinding() {
        Binding binding = new Binding(
                "ecommerce-order-event-queue", // queue name or exchange name
                Binding.DestinationType.QUEUE, // queue or exchange
                "ecommerce-order-event-exchange",
                "ecommerce-order-event-queue",
                null);
        amqpAdmin.declareBinding(binding);
    }

    @Test
    public void send() {
        String msg = "333333333";
        rabbitTemplate.convertAndSend(
                "ecommerce-order-event-exchange",
                "ecommerce-order-event-queue",
                msg);
        log.info("send: {}", msg);
    }
}
