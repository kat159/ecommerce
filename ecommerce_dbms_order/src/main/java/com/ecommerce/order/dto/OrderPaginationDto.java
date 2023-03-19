package com.ecommerce.order.dto;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.order.entity.OrderSku;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class OrderPaginationDto extends PaginationDto {

    private OrderSku.Status status;
    private String username;
}
