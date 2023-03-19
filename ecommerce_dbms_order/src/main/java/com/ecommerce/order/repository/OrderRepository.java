package com.ecommerce.order.repository;

import com.ecommerce.order.entity.Order;
import com.ecommerce.order.entity.OrderSku;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {
    Order findByOrderUUID(String uuid);

    Page<Order> findByOrderSkus_RefundRequests_StatusNotIn(PageRequest pageRequest, List<Integer> asList);

    @Query("SELECT o FROM Order o JOIN o.orderSkus os WHERE os.rating IS NOT NULL")
    Page<Order> findDistinctByOrderSkus_RatingIsNotNull(PageRequest pageRequest);

    Page<Order> findDistinctByOrderSkus_Status(OrderSku.Status status, PageRequest pageRequest);
}
