package com.ecommerce.order.config;


import com.ecommerce.order.quartz.RabbitMQMessageRetryJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    private static final String STOCK_DEDUCTION_JOB_IDENTITY = "MessageRetryJob";

    @Bean
    public JobDetail stockDeductionJobDetail() {
        return JobBuilder.newJob(RabbitMQMessageRetryJob.class)
                .withIdentity(STOCK_DEDUCTION_JOB_IDENTITY)
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger stockDeductionJobTrigger() {
        return TriggerBuilder.newTrigger()
                .forJob(stockDeductionJobDetail())
                .withIdentity(STOCK_DEDUCTION_JOB_IDENTITY + "Trigger")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(10)
                        .repeatForever())
                .build();
    }
}