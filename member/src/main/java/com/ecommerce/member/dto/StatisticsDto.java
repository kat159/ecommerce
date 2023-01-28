package com.ecommerce.member.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
@ApiModel(value = "Partitioned data, aggregated anformation, one to one member")
public class StatisticsDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "ID")
	private Long id;

	@ApiModelProperty(value = "Member ID")
	private Long memberId;

	@ApiModelProperty(value = "Accumulated payment")
	private BigDecimal accumPayment;

	@ApiModelProperty(value = "Accumulated discount Amount")
	private BigDecimal accumDiscount;

	@ApiModelProperty(value = "Order Count")
	private Integer numOrder;

	@ApiModelProperty(value = "Coupon Count")
	private Integer numCoupon;

	@ApiModelProperty(value = "Comment Count")
	private Integer numComment;

	@ApiModelProperty(value = "Return Order Count")
	private Integer numReturnOrder;

	@ApiModelProperty(value = "Login Count")
	private Integer numLogin;

	@ApiModelProperty(value = "Attention Count")
	private Integer numAttend;

	@ApiModelProperty(value = "Fans Count")
	private Integer numFans;

	@ApiModelProperty(value = "Refer friend Count")
	private Integer numRefer;


}