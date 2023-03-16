package com.ecommerce.product.repository;

import com.ecommerce.product.entity.StockDeductionRollback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockDeductionRollbackDao extends JpaRepository<StockDeductionRollback, Long> {
}
