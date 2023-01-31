package com.ecommerce.order.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@ApiModel(value = "order_return_application")
public class OrderReturnApplicationDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "order_id")
	private Long orderId;

	@ApiModelProperty(value = "skuid")
	private Long skuId;

	@ApiModelProperty(value = "order series num")
	private String orderSn;

	@ApiModelProperty(value = "application date")
	private Date date;

	@ApiModelProperty(value = "applicant username")
	private String username;

	@ApiModelProperty(value = "refund amount")
	private BigDecimal refundAmount;

	@ApiModelProperty(value = "refund receriver name")
	private String refundName;

	@ApiModelProperty(value = "refund receiver tele num")
	private String refundTele;

	@ApiModelProperty(value = "[0->Pending; 1->Returning; 2->Completed; 3->Rejected]")
	private Integer status;

	@ApiModelProperty(value = "The time when the application was processed")
	private Date processDate;

	@ApiModelProperty(value = "Product image")
	private String skuImg;

	@ApiModelProperty(value = "Product name")
	private String skuName;

	@ApiModelProperty(value = "Product brand")
	private String skuBrand;

	@ApiModelProperty(value = "Product sales attributes (JSON)")
	private String skuAttrsVals;

	@ApiModelProperty(value = "Return quantity")
	private Integer skuCount;

	@ApiModelProperty(value = "Product unit price")
	private BigDecimal skuPrice;

	@ApiModelProperty(value = "Product actual payment unit price")
	private BigDecimal skuFinalPrice;

	@ApiModelProperty(value = "Reason")
	private String reason;

	@ApiModelProperty(value = "Description")
	private String description;

	@ApiModelProperty(value = "proof pictures, separated by commas")
	private String proofImgs;

	@ApiModelProperty(value = "Processing notes")
	private String processNote;

	@ApiModelProperty(value = "Processing personnel")
	private String proccessor;

	@ApiModelProperty(value = "Receiver")
	private String consignee;

	@ApiModelProperty(value = "date when received ")
	private Date packageArriveDate;

	@ApiModelProperty(value = "package note")
	private String packageNote;

	@ApiModelProperty(value = "Receiver's phone")
	private String consigneePhone;

	@ApiModelProperty(value = "receiving address")
	private String consigneeAddress;


}