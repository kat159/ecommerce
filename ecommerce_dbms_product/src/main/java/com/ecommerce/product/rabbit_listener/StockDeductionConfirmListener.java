package com.ecommerce.product.rabbit_listener;


import com.ecommerce.common.constant.RabbitMQConstant;
import com.ecommerce.common.dto.internal_dto.OrderSkuInternalDto;
import com.ecommerce.product.service.SkuService;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@RabbitListener(queues = RabbitMQConstant.INVENTORY_DEDUCTION_CONFIRM_QUEUE)
@Service
public class StockDeductionConfirmListener {
    @Autowired
    private SkuService skuService;
    @RabbitHandler
    public void handleStockDeductionConfirm(
            String orderUUID,
            Message message,
            Channel channel) {
        log.info("Received stock deduction confirm message: {}", orderUUID);
        log.info("Message: {}", message);
        log.info("Channel: {}", channel);
        skuService.confirmInventoryDeduction(orderUUID);
    }
}
