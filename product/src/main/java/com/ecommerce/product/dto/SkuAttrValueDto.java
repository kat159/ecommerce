package com.ecommerce.product.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "sku to attr join table, with redundant sale attributes and values")
public class SkuAttrValueDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "sku id")
	private Long skuId;

	@ApiModelProperty(value = "attribute id")
	private Long attrId;

	@ApiModelProperty(value = "sale attribute name")
	private String attrName;

	@ApiModelProperty(value = "sale attribute value")
	private String attrValue;

	@ApiModelProperty(value = "sort order")
	private Integer attrSort;


}