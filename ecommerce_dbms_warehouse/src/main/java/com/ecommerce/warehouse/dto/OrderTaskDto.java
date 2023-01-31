package com.ecommerce.warehouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



@Data
@ApiModel(value = "order task")
public class OrderTaskDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "ID")
	private Long id;

	@ApiModelProperty(value = "Order ID")
	private Long orderId;

	@ApiModelProperty(value = "Order serial number")
	private String orderSn;

	@ApiModelProperty(value = "Recipient")
	private String consignee;

	@ApiModelProperty(value = "Recipient telephone")
	private String consigneeTel;

	@ApiModelProperty(value = "Delivery address")
	private String deliveryAddress;

	@ApiModelProperty(value = "Order notet")
	private String orderNote;

	@ApiModelProperty(value = "Payment method [1: online payment, 2: pay on delivery]")
	private Integer paymentMethod;

	@ApiModelProperty(value = "Task status")
	private Integer status;

	@ApiModelProperty(value = "Order description")
	private String description;

	@ApiModelProperty(value = "Tracking number")
	private String trackingNumber;

	@ApiModelProperty(value = "Date created")
	private Date createDate;

	@ApiModelProperty(value = "Warehouse ID")
	private Long warehouseId;

	@ApiModelProperty(value = "Task note")
	private String taskNote;


}