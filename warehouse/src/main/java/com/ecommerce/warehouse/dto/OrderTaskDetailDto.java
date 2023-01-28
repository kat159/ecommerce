package com.ecommerce.warehouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "order task detail")
public class OrderTaskDetailDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "ID")
	private Long id;

	@ApiModelProperty(value = "SKU ID")
	private Long skuId;

	@ApiModelProperty(value = "SKU name")
	private String skuName;

	@ApiModelProperty(value = "Number of purchased items")
	private Integer skuNum;

	@ApiModelProperty(value = "Task ID")
	private Long taskId;


}