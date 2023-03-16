package com.ecommerce.product.entity;

import com.ecommerce.common.dto.internal_dto.OrderSkuInternalDto;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class StockDeductionRollback{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String orderUUID;
    private Long skuId;
    private Long quantity;
    private LocalDateTime createDate = LocalDateTime.now();
}
