package com.ecommerce.coupon.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "Products avaiable to use corresponding coupon")
public class CouponAppliedProductDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "ID")
	private Long id;

	@ApiModelProperty(value = "Coupon ID")
	private Long couponId;

	@ApiModelProperty(value = "Product ID")
	private Long productId;

	@ApiModelProperty(value = "Product Name")
	private String productName;


}