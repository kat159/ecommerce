package com.ecommerce.coupon.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



@Data
@ApiModel(value = "Status of coupon collected by members")
public class CollectedCouponStatusDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "ID")
	private Long id;

	@ApiModelProperty(value = "Coupon ID")
	private Long couponId;

	@ApiModelProperty(value = "Member ID")
	private Long memberId;

	@ApiModelProperty(value = "Member Name")
	private String memberNickname;

	@ApiModelProperty(value = "Acquisition Method [0-> Backend Giveaway; 1-> Active Reception]")
	private Integer collectionType;

	@ApiModelProperty(value = "Creation Time")
	private Date createTime;

	@ApiModelProperty(value = "Use Status [0-> Not Used; 1-> Used; 2-> Expired]")
	private Integer status;

	@ApiModelProperty(value = "Date when used")
	private Date usedDate;

	@ApiModelProperty(value = "Order ID of the order paid with this coupon")
	private Long orderId;

	@ApiModelProperty(value = "Order series numbe of the order paid with this couponr")
	private Long orderSn;


}