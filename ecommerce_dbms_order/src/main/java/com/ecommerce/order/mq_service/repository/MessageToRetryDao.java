package com.ecommerce.order.mq_service.repository;

import com.ecommerce.order.mq_service.entity.MessageToRetry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MessageToRetryDao extends JpaRepository<MessageToRetry, Long> {
    List<MessageToRetry> findAllByCreateDateBefore(LocalDateTime oneMinuteAgo);
}
