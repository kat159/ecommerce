package com.ecommerce.product.dto.pagination;

import com.ecommerce.common.dto.PaginationDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class ProductSearchParams
        extends PaginationDto
        implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * filters based on product info
     */
    private String keyword;
    private Long categoryId;
    private List<Long> brandIds;
    private List<AttrFilter> specAttrFilters;
    /**
     * filters based on sku info
     */
    private List<AttrFilter> saleAttrFilters;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;

}
