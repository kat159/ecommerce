package com.ecommerce.common.constant;

public interface RabbitMQConstant {
    String ORDER_SERVICE_TOPIC_EXCHANGE = "order_service_topic_exchange";
    String ORDER_CREATE_CONFIRM_ROUTING_KEY = "order.create.confirm";
    String INVENTORY_DEDUCTION_CONFIRM_QUEUE = "inventory_deduction_confirm_queue";
}
