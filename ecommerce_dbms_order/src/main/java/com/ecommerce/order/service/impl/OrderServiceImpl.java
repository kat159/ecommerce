package com.ecommerce.order.service.impl;

import com.ecommerce.common.constant.RabbitMQConstant;
import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.dto.internal_dto.OrderSkuInternalDto;
import com.ecommerce.common.dto.internal_dto.SkuInternalDto;
import com.ecommerce.common.utils.Result;
import com.ecommerce.order.dto.OrderCheckoutDto;
import com.ecommerce.order.dto.OrderSkuDto;
import com.ecommerce.order.dto.PlaceOrderDto;
import com.ecommerce.order.entity.Order;
import com.ecommerce.order.entity.OrderSku;
import com.ecommerce.order.mq_service.RabbitMQService;
import com.ecommerce.order.open_feign.ProductClient;
import com.ecommerce.order.repository.OrderRepository;
import com.ecommerce.order.repository.OrderSkuRepository;
import com.ecommerce.order.service.OrderService;
import com.ecommerce.order.vo.OrderCheckoutVo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderSkuRepository orderSkuRepository;
    @Autowired
    private ProductClient productClient;
    @Autowired
    private RabbitMQService rabbitMQService;

    Set<String> orderUUIDs = new HashSet<>(); // todo: use redis instead

    @Override
    public OrderCheckoutVo checkout(OrderCheckoutDto orderCheckoutDto) {
        System.out.println("checkout: " + orderUUIDs);
        String orderUUID = UUID.randomUUID().toString();
        orderUUIDs.add(orderUUID);
        OrderCheckoutVo orderCheckoutVo = new OrderCheckoutVo();
        orderCheckoutVo.setOrderUUID(orderUUID);
        return orderCheckoutVo;
    }

    private synchronized Boolean checkOrderUUID(String orderUUID) {
        if (orderUUID == null || !orderUUIDs.contains(orderUUID)) {
            return false;
        }
        orderUUIDs.remove(orderUUID);
        return true;
    }

    @Override
    @Transactional
    public void placeOrder(PlaceOrderDto placeOrderDto) {
        String orderUUID = placeOrderDto.getOrderUUID();
        // TODO: check orderUUID
        if (!checkOrderUUID(orderUUID)) {
            throw new RuntimeException("Order UUID is invalid");
        }
        // TODO: check sku price & stock
        List<Long> ids = placeOrderDto.getSkus().stream().map(OrderSkuDto::getSkuId).collect(Collectors.toList());
        System.out.println("ids: " + ids);
        PaginationDto paginationDto = new PaginationDto();
        paginationDto.setIds(ids);
        // Result res = productClient.getAll(paginationDto);
        Result<List<SkuInternalDto>> res = productClient.getAll(new PaginationDto());

        Map<Long, SkuInternalDto> idToSku = res.getData().stream().collect(Collectors.toMap(SkuInternalDto::getId, sku -> sku));
        List<OrderSkuInternalDto> toDeductSkuList = new ArrayList<>();

        for (OrderSkuDto orderSkuDto : placeOrderDto.getSkus()) {
            SkuInternalDto sku = idToSku.get(orderSkuDto.getSkuId());
            if (sku == null) {
                throw new RuntimeException("sku not found");
            }
            if (sku.getFinalPrice().compareTo(orderSkuDto.getSkuFinalPrice()) != 0) {
                throw new RuntimeException("sku price changed");
            }
            if (sku.getStock() < orderSkuDto.getSkuQuantity()) {
                throw new RuntimeException("sku stock not enough");
            }
            OrderSkuInternalDto orderSkuInternalDto = new OrderSkuInternalDto();
            orderSkuInternalDto.setSkuId(sku.getId());
            orderSkuInternalDto.setQuantity(orderSkuDto.getSkuQuantity());
            orderSkuInternalDto.setOrderUUID(orderUUID);
            toDeductSkuList.add(orderSkuInternalDto);
        }
        // deduct stock
        productClient.deductInventory(toDeductSkuList);
        // process payment
        String transactionId = UUID.randomUUID().toString();
        // create order
        /*
        Order order = new Order();
        order.setTransactionId(transactionId);
        BeanUtils.copyProperties(placeOrderDto, order);
        orderRepository.save(order);

        List<OrderSku> orderSkuList = new ArrayList<>();
        for (OrderSkuDto orderSkuDto : placeOrderDto.getSkus()) {
            OrderSku orderSku = new OrderSku();
            BeanUtils.copyProperties(orderSkuDto, orderSku);
            orderSku.setOrderId(order.getId());
            orderSkuList.add(orderSku);
        }
        orderSkuRepository.saveAll(orderSkuList);
         */
        Order order = new Order();
        order.setTransactionId(transactionId);
        order.setStatus(Order.Status.PAYMENT_VERIFIED);  // todo: currently init as payment verified
        BeanUtils.copyProperties(placeOrderDto, order);

        List<OrderSku> orderSkuList = new ArrayList<>();
        for (OrderSkuDto orderSkuDto : placeOrderDto.getSkus()) {
            OrderSku orderSku = new OrderSku();
            BeanUtils.copyProperties(orderSkuDto, orderSku);
            orderSku.setStatus(OrderSku.Status.DELIVERED); // todo: currently init as delivered
            orderSku.setOrder(order);
            orderSkuList.add(orderSku);
        }
        orderSkuRepository.saveAll(orderSkuList);

        order.setOrderSkus(orderSkuList);
        orderRepository.save(order);

        rabbitMQService.send(
                RabbitMQConstant.ORDER_SERVICE_TOPIC_EXCHANGE,
                RabbitMQConstant.ORDER_CREATE_CONFIRM_ROUTING_KEY,
                orderUUID);
    }

}
