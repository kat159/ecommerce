package com.ecommerce.order.repository;

import com.ecommerce.order.entity.OrderSkuShippingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderSkuShippingStatusRepository extends JpaRepository<OrderSkuShippingStatus, Long> {
}
