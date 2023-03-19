package com.ecommerce.order.quartz;


import com.ecommerce.order.mq_service.RabbitMQService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@DisallowConcurrentExecution
public class RabbitMQMessageRetryJob implements Job {
    @Autowired
    private RabbitMQService rabbitMQService;
    @Override
    public void execute(org.quartz.JobExecutionContext context) {
        System.out.println("quartz job start");
        rabbitMQService.retry();
    }
}
