package com.ecommerce.product.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "join table attr to attr_group")
public class AttributeAttributeGroupDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "attribute ID")
	private Long attrId;

	@ApiModelProperty(value = "attribute group ID")
	private Long attrGroupId;

	@ApiModelProperty(value = "sort order within group")
	private Integer attrSort;


}