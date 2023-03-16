package com.ecommerce.product.repository;

import com.ecommerce.product.entity.StockDeductionOfUnconfirmedOrder;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StockDeductionOfUnconfirmedOrderDao extends JpaRepository<StockDeductionOfUnconfirmedOrder, Long> {
    List<StockDeductionOfUnconfirmedOrder> findAllByOrderUUID(String orderUUID);

    void deleteAllByOrderUUID(String orderUUID);

    List<StockDeductionOfUnconfirmedOrder> getFirst1000Rows();

    void deleteByOrderUUID(String orderUUID);

    StockDeductionOfUnconfirmedOrder findFirst();
}
