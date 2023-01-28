package com.ecommerce.warehouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@ApiModel(value = "purchase order information")
public class PurchaseDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Purchase ID")
	private Long id;

	@ApiModelProperty(value = "ID of the person making the purchase")
	private Long assigneeId;

	@ApiModelProperty(value = "Name of the person making the purchase")
	private String assigneeName;

	@ApiModelProperty(value = "tele number of the person making the purchase")
	private String assigneeTele;

	@ApiModelProperty(value = "Priority")
	private Integer priority;

	@ApiModelProperty(value = "Status")
	private Integer status;

	@ApiModelProperty(value = "Warehouse ID")
	private Long warehouseId;

	@ApiModelProperty(value = "Total amount")
	private BigDecimal amount;

	@ApiModelProperty(value = "Date created")
	private Date createDate;

	@ApiModelProperty(value = "Date updated")
	private Date updateDate;


}