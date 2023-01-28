package com.ecommerce.order.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@ApiModel(value = "order")
public class OrderDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "member id")
	private Long memberId;

	@ApiModelProperty(value = "order number")
	private String orderSn;

	@ApiModelProperty(value = "coupon used")
	private Long couponId;

	@ApiModelProperty(value = "create time")
	private Date createTime;

	@ApiModelProperty(value = "username")
	private String memberUsername;

	@ApiModelProperty(value = "total order amount")
	private BigDecimal totalAmount;

	@ApiModelProperty(value = "amount to pay")
	private BigDecimal payAmount;

	@ApiModelProperty(value = "freight amount")
	private BigDecimal freightAmount;

	@ApiModelProperty(value = "promotion amount (special price, member price, price break, volume discount)")
	private BigDecimal discountAmountPromotion;

	@ApiModelProperty(value = "reduced amount by reward point")
	private BigDecimal discountAmountRewardPoint;

	@ApiModelProperty(value = "coupon amount")
	private BigDecimal discountAmountCoupon;

	@ApiModelProperty(value = "discount amount adjusted by admin")
	private BigDecimal discountAmountAdmin;

	@ApiModelProperty(value = "payment method [0->debit card; 1->credit card; 2->paypal; 3->cash on delivery; 4->others]")
	private Integer paymentMethod;

	@ApiModelProperty(value = "order source [0->website; 1->app]")
	private Integer paymentApp;

	@ApiModelProperty(value = "order status [0->not paid; 1->not shipped; 2->shipped; 3->completed; 4->closed; 5->invalid order]")
	private Integer status;

	@ApiModelProperty(value = "delivery company")
	private String deliveryCompany;

	@ApiModelProperty(value = "tracking_number")
	private String deliveryTrackingNumber;

	@ApiModelProperty(value = "auto confirm time (days)")
	private Integer autoConfirmDay;

	@ApiModelProperty(value = "integration earned")
	private Integer integration;

	@ApiModelProperty(value = "membership_point earned")
	private Integer membershipPoint;

	@ApiModelProperty(value = "bill/invoice type [0->no invoice; 1->electronic invoice; 2->paper invoice]")
	private Integer billType;

	@ApiModelProperty(value = "bill/invoice header")
	private String billHeader;

	@ApiModelProperty(value = "bill/invoice content")
	private String billContent;

	@ApiModelProperty(value = "bill/invoice receiver phone")
	private String billReceiverPhone;

	@ApiModelProperty(value = "bill/invoice receiver email")
	private String billReceiverEmail;

	@ApiModelProperty(value = "receiver name")
	private String receiverName;

	@ApiModelProperty(value = "receiver phone")
	private String receiverPhone;

	@ApiModelProperty(value = "receiver post code")
	private String receiverPostcode;

	@ApiModelProperty(value = "province/metropolis")
	private String receiverProvince;

	@ApiModelProperty(value = "city")
	private String receiverCity;

	@ApiModelProperty(value = "region")
	private String receiverRegion;

	@ApiModelProperty(value = "receiver detail address")
	private String receiverAddress;

	@ApiModelProperty(value = "order note")
	private String note;

	@ApiModelProperty(value = "Confirmation of receipt status [0-> Not confirmed; 1-> Confirmed]")
	private Integer confirmStatus;

	@ApiModelProperty(value = "Deletion status [0-> Not deleted; 1-> Deleted]")
	private Integer deleteStatus;

	@ApiModelProperty(value = "Points used at the time of ordering")
	private Integer usedRewardPoint;

	@ApiModelProperty(value = "Payment date")
	private Date paymentDate;

	@ApiModelProperty(value = "Shipping date")
	private Date shippingDate;

	@ApiModelProperty(value = "Confirmation of receipt date")
	private Date receiveDate;

	@ApiModelProperty(value = "Comment date")
	private Date commentDate;

	@ApiModelProperty(value = "edte date")
	private Date editDate;


}