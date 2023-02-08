package com.ecommerce.product.vo.category;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "product category, up to three-level categorization")
public class CategoryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "category id")
    private Long id;
    @ApiModelProperty(value = "category name")
    private String name;
    @ApiModelProperty(value = "parent category id")
    private Long parentId;
    @ApiModelProperty(value = "sort order")
    private Integer sort;
    @ApiModelProperty(value = "icon address")
    private String icon;

}