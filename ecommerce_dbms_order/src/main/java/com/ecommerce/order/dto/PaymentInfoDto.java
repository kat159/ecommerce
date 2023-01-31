package com.ecommerce.order.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@ApiModel(value = "Payment Information Table")
public class PaymentInfoDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "ID")
	private Long id;

	@ApiModelProperty(value = "Order Number (External Business Number)")
	private String orderSn;

	@ApiModelProperty(value = "Order ID")
	private Long orderId;

	@ApiModelProperty(value = "transaction Serial Number")
	private String transactionSn;

	@ApiModelProperty(value = "Total Payment Amount")
	private BigDecimal totalAmount;

	@ApiModelProperty(value = "Transaction Content")
	private String content;

	@ApiModelProperty(value = "Payment Status")
	private String paymentStatus;

	@ApiModelProperty(value = "Creation date")
	private Date createDate;

	@ApiModelProperty(value = "Confirmation date")
	private Date confirmDate;

	@ApiModelProperty(value = "Callback Content")
	private String callbackContent;

	@ApiModelProperty(value = "Callback Time")
	private Date callbackTime;


}