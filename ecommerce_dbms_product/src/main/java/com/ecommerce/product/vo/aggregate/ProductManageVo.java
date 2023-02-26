package com.ecommerce.product.vo.aggregate;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ProductManageVo
        implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long categoryId;
    private Long brandId;
    @ApiModelProperty(value = "product name")
    private String name;
    @ApiModelProperty(value = "product description")
    private String description;
    @ApiModelProperty(value = "publish status [0 - not published, 1 - published]")
    private Integer publishStatus;
    private String brandName;
    private String categoryName;
}
