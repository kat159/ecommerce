package com.ecommerce.product.vo;

import com.ecommerce.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "product attribute")
public class AttributeVo extends BaseVo<AttributeVo>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Attribute ID")
    private Long id;
    @ApiModelProperty(value = "")
    private Long attributeGroupId;
    @ApiModelProperty(value = "attribute name")
    private String name;
    @ApiModelProperty(value = "attribute icon")
    private String icon;
    @ApiModelProperty(value = "[0-no, 1-yes]")
    private Integer searchStatus;
    @ApiModelProperty(value = "[0-single value, 1-multiple values can be selected]")
    private Integer selective;
    @ApiModelProperty(value = "list of selectable values (separated by commas)")
    private String selectableValueList;
    @ApiModelProperty(value = "attribute type [0-sale attribute, 1-basic attribute, 2-both sale and basic attribute]")
    private Integer type;
    @ApiModelProperty(value = "status [0 - disabled, 1 - enabled]")
    private Long status;
    @ApiModelProperty(value = "[display on introduction or not; 0-no 1-yes], can still be adjusted in sku")
    private Integer display;

}