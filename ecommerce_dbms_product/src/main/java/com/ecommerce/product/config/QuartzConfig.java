package com.ecommerce.product.config;


import com.ecommerce.product.quartz.StockDeductionConfirmJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    private static final String STOCK_DEDUCTION_JOB_IDENTITY = "stockDeductionJob";

    @Bean
    public JobDetail stockDeductionJobDetail() {
        return JobBuilder.newJob(StockDeductionConfirmJob.class)
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
                        .withIntervalInSeconds(60 * 5)
                        .repeatForever())
                .build();
    }
}