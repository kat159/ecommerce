package com.ecommerce.order.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
@ApiModel(value = "Refund Information")
public class RefundInfoDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "ID")
	private Long id;

	@ApiModelProperty(value = "Refund Order id")
	private Long orderId;

	@ApiModelProperty(value = "Refund Amount")
	private BigDecimal refundAmount;

	@ApiModelProperty(value = "Refund Transaction Serial Number")
	private String refundSn;

	@ApiModelProperty(value = "Refund Status")
	private Integer refundStatus;

	@ApiModelProperty(value = "Refund Channel [1-debit card, 2-credit card, 3-paypal, 4-others]")
	private Integer refundChannel;

	@ApiModelProperty(value = "")
	private String refundContent;


}