package com.ecommerce.product.dto.pagination;

import com.ecommerce.common.dto.PaginationDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;


@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class CategoryPaginationDto extends PaginationDto implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * category level
     */
    private Integer level;
    /**
     * name prefix, sql: like '%name'
     */
    private String name;
}
