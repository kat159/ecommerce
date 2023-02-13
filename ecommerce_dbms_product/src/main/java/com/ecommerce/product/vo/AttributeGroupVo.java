package com.ecommerce.product.vo;

import com.ecommerce.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "attribute group")
public class AttributeGroupVo extends BaseVo<AttributeGroupVo> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "group ID")
    private Long id;
    // @ApiModelProperty(value = "category it belongs to")
    // private Long categoryId;
    @ApiModelProperty(value = "group name")
    private String name;
    @ApiModelProperty(value = "sort order")
    private Integer sort;
    @ApiModelProperty(value = "description")
    private String description;
    @ApiModelProperty(value = "group icon")
    private String icon;

}