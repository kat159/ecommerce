package com.ecommerce.order.repository;

import com.ecommerce.order.entity.OrderSkuRefundRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderSkuRefundRequestRepository extends JpaRepository<OrderSkuRefundRequest, Long> {
}
