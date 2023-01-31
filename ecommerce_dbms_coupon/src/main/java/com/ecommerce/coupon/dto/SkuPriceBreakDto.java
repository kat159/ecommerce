package com.ecommerce.coupon.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
@ApiModel(value = "SKU full reduction information")
public class SkuPriceBreakDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "SKU ID")
	private Long skuId;

	@ApiModelProperty(value = "amount threshold to apply discounted price")
	private BigDecimal threshold;

	@ApiModelProperty(value = "discounted price")
	private BigDecimal discountedPrice;

	@ApiModelProperty(value = "Whether can be combined with other offer")
	private Integer combinable;


}