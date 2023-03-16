package com.ecommerce.product.repository;

import com.ecommerce.product.entity.StockDeductionOfConfirmedOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface StockDeductionOfConfirmedOrderDao extends JpaRepository<StockDeductionOfConfirmedOrder, Long> {
}
