package com.ecommerce.coupon.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
@ApiModel(value = "Promotion-Sku join table")
public class PromotionSkuDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "Promotion ID")
	private Long promotionId;

	@ApiModelProperty(value = "Promotion session ID")
	private Long promotionSessionId;

	@ApiModelProperty(value = "SKU ID")
	private Long skuId;

	@ApiModelProperty(value = "Special price")
	private BigDecimal specialPrice;

	@ApiModelProperty(value = "Seckill total quantity")
	private BigDecimal limitTotalNumber;

	@ApiModelProperty(value = "Limit per person")
	private BigDecimal limitNumberPerMember;

	@ApiModelProperty(value = "Sort order")
	private Integer sort;


}