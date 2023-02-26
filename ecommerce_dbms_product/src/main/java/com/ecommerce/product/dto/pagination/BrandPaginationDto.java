package com.ecommerce.product.dto.pagination;

import com.ecommerce.common.dto.PaginationDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class BrandPaginationDto extends PaginationDto {
    private static final long serialVersionUID = 1L;
    /**
     * name prefix, sql: like '%name'
     */
    private String name;
}
