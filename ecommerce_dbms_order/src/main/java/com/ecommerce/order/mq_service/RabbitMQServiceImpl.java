package com.ecommerce.order.mq_service;

import com.ecommerce.common.constant.RabbitMQConstant;
import com.ecommerce.order.mq_service.RabbitMQService;
import com.ecommerce.order.mq_service.entity.MessageToRetry;
import com.ecommerce.order.mq_service.repository.MessageToRetryDao;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class RabbitMQServiceImpl implements RabbitMQService {
    @Autowired
    private MessageToRetryDao messageToRetryDao;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (ack) {
                System.out.println("send message success");
                if (correlationData != null) {
                    String id = correlationData.getId();
                    System.out.println("id: " + Long.parseLong(id));
                    System.out.println(messageToRetryDao.findById(Long.parseLong(id)));
                    messageToRetryDao.deleteById(Long.parseLong(id));
                    System.out.println("delete message from retry table");
                } else {
                    System.out.println("correlationData is null");
                }

            } else {
                System.out.println("send message failed");
            }
        });
        rabbitTemplate.setReturnsCallback(returned -> {
            System.out.println("Message returned");
        });
    }
    @Override
    public void send(String exchange, String routingKey, String message) {
        MessageToRetry entityToSave = new MessageToRetry(exchange, routingKey, message);
        System.out.println("save message to retry table: " + entityToSave);
        MessageToRetry entity = messageToRetryDao.saveAndFlush(entityToSave);
        System.out.println("save message to retry table: " + entity);
        rabbitTemplate.convertAndSend(
                exchange,
                routingKey,
                message,
                new CorrelationData(entity.getId().toString())
        );
    }

    @Override
    public void retry() {
        System.out.println("quatrz job start");
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime oneMinuteAgo = currentTime.minusMinutes(1);
        List<MessageToRetry> messagesToRetry = messageToRetryDao.findAllByCreateDateBefore(oneMinuteAgo);

        for (MessageToRetry messageToRetry : messagesToRetry) {
            rabbitTemplate.convertAndSend(
                    messageToRetry.getExchange(),
                    messageToRetry.getRoutingKey(),
                    messageToRetry.getMessage(),
                    new CorrelationData(messageToRetry.getId().toString())
            );
            messageToRetry.setRetryCount(messageToRetry.getRetryCount() + 1);
            messageToRetry.setCreateDate(LocalDateTime.now());
            messageToRetryDao.save(messageToRetry);
        }
    }
}
