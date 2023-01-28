package com.ecommerce.coupon.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
@ApiModel(value = "Product Member Price")
public class MemberPriceDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "SKU ID")
	private Long skuId;

	@ApiModelProperty(value = "Member level ID")
	private Long memberLevelId;

	@ApiModelProperty(value = "Member level name")
	private String memberLevelName;

	@ApiModelProperty(value = "Price for member")
	private BigDecimal memberPrice;

	@ApiModelProperty(value = "Can be combined with other discounts [0-Cannot be combined, 1-Can be combined]")
	private Integer stackable;


}