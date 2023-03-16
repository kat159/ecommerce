package com.ecommerce.product.quartz;


import com.ecommerce.common.constant.RabbitMQConstant;
import com.ecommerce.product.repository.StockDeductionOfConfirmedOrderDao;
import com.ecommerce.product.repository.StockDeductionOfUnconfirmedOrderDao;
import com.ecommerce.product.repository.StockDeductionRollbackDao;
import com.ecommerce.product.service.SkuService;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import io.swagger.annotations.Scope;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

@Component
@Slf4j
@DisallowConcurrentExecution
public class StockDeductionConfirmJob implements Job {
    @Autowired
    private SkuService skuService;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    private int count = 0;
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // if size of messages in RabbitMQConstant.INVENTORY_DEDUCTION_CONFIRM_QUEUE is > 10000, do nothing
        //    else,skuService.scanAndRollbackInventoryDeduction();
        Integer queueSize = rabbitTemplate.execute(channel -> {
            try {
                return channel.queueDeclarePassive(RabbitMQConstant.INVENTORY_DEDUCTION_CONFIRM_QUEUE).getMessageCount();
            } catch (Exception e) {
                log.error("Failed to get queue size: {}", e.getMessage());
                return null;
            }
        });
        if (queueSize != null) {
            if (queueSize > 10000) {
                log.info("Order_To_Confirm_Queue size is too large, do nothing");
                return;
            }
        } else {
            System.out.println("Failed to get queue size.");
        }
        System.out.println(count++);
        skuService.scanAndRollbackInventoryDeduction();
    }
}
