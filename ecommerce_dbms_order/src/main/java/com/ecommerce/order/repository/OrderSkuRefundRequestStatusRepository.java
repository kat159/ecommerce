package com.ecommerce.order.repository;

import com.ecommerce.order.entity.OrderSkuRefundRequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderSkuRefundRequestStatusRepository extends JpaRepository<OrderSkuRefundRequestStatus, Long> {
}
