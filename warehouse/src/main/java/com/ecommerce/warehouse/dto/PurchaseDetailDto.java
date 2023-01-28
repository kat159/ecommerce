package com.ecommerce.warehouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
@ApiModel(value = "purchase order detail, many to one purchase")
public class PurchaseDetailDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "")
	private Long id;

	@ApiModelProperty(value = "Purchase ID")
	private Long purchaseId;

	@ApiModelProperty(value = "ID of the purchased item")
	private Long skuId;

	@ApiModelProperty(value = "Quantity purchased")
	private Integer skuNum;

	@ApiModelProperty(value = "Purchase amount")
	private BigDecimal skuPrice;

	@ApiModelProperty(value = "Warehouse ID")
	private Long warehouseId;

	@ApiModelProperty(value = "Status [0: new, 1: assigned, 2: in progress, 3: completed, 4: purchase failed]")
	private Integer status;


}