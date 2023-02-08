package com.ecommerce.common.dto;

import com.ecommerce.common.validation.annotation.StringEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class PaginationDto implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * current page number
     */
    private Long current;
    /**
     * size of each page
     */
    // @NotNull(message = "page size is required")
    private Long pageSize;
    /**
     * names of fields to order by
     */
    private List<String> orderFields;
    /**
     * orderTypes: asc or desc
     */
    private List<String> orderTypes;
}
