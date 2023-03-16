package com.ecommerce.order.repository;

import com.ecommerce.order.entity.OrderSku;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderSkuRepository extends JpaRepository<OrderSku, Long> {
}
