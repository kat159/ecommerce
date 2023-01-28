package com.ecommerce.product.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "product attribute value, many to one product")
public class ProductAttrbuteValueDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "product id")
	private Long productId;

	@ApiModelProperty(value = "attribute id")
	private Long attributeId;

	@ApiModelProperty(value = "attribute name")
	private String attributeName;

	@ApiModelProperty(value = "attribute value")
	private String attributeValue;

	@ApiModelProperty(value = "sort order")
	private Integer attributeSort;

	@ApiModelProperty(value = "[whether to display on introduction; 0-no 1-yes]")
	private Integer display;


}