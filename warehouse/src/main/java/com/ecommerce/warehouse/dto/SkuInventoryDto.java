package com.ecommerce.warehouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "sku_inventory")
public class SkuInventoryDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "ID")
	private Long id;

	@ApiModelProperty(value = "SKU ID")
	private Long skuId;

	@ApiModelProperty(value = "Warehouse ID")
	private Long warehouseId;

	@ApiModelProperty(value = "Stock quantity")
	private Integer stockCount;

	@ApiModelProperty(value = "SKU name")
	private String skuName;

	@ApiModelProperty(value = "Locked stock")
	private Integer stockLockedCount;


}