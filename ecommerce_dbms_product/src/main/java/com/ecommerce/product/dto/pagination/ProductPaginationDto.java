package com.ecommerce.product.dto.pagination;

import com.ecommerce.common.dto.PaginationDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class ProductPaginationDto
        extends PaginationDto
    implements Serializable {

    private static final long serialVersionUID = 1L;


}
