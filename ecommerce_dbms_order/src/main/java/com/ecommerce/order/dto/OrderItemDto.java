package com.ecommerce.order.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
@ApiModel(value = "order item information")
public class OrderItemDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "order id")
	private Long orderId;

	@ApiModelProperty(value = "order serial number")
	private String orderSn;

	@ApiModelProperty(value = "product id")
	private Long productId;

	@ApiModelProperty(value = "product name")
	private String productName;

	@ApiModelProperty(value = "product img")
	private String productImg;

	@ApiModelProperty(value = "brand")
	private String productBrand;

	@ApiModelProperty(value = "product category id")
	private Long categoryId;

	@ApiModelProperty(value = "product sku number")
	private Long skuId;

	@ApiModelProperty(value = "product sku name")
	private String skuName;

	@ApiModelProperty(value = "product sku picture")
	private String skuImg;

	@ApiModelProperty(value = "product sku price")
	private BigDecimal skuPrice;

	@ApiModelProperty(value = "quantity of product purchased")
	private Integer skuQuantity;

	@ApiModelProperty(value = "JSON of product sales attributes")
	private String skuAttributeValues;

	@ApiModelProperty(value = "amount of promotion breakdown")
	private BigDecimal discountAmount;

	@ApiModelProperty(value = "amount of coupon discount breakdown")
	private BigDecimal couponAmount;

	@ApiModelProperty(value = "amount of points discount breakdown")
	private BigDecimal rewardAmount;

	@ApiModelProperty(value = "the breakdown amount after discounts")
	private BigDecimal paymentAmount;

	@ApiModelProperty(value = "gift points")
	private Integer giftRewardPoints;

	@ApiModelProperty(value = "gift points")
	private Integer giftMembershipPoint;


}