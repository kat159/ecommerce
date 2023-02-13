package com.ecommerce.product.dto.pagination;

import com.ecommerce.common.dto.PaginationDto;
import lombok.Data;


@Data
public class BrandPaginationDto extends PaginationDto {
    private static final long serialVersionUID = 1L;
    /**
     * name prefix, sql: like '%name'
     */
    private String name;
}
