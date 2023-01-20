package com.ecommerce.product.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CategoryDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long catId;
    private String name;
    private Long parentCid;
    private Integer catLevel;
    private Integer showStatus;
    private Integer sort;
    private String icon;
    private String productUnit;
    private Integer productCount;
    private List<CategoryDto> children;
}
