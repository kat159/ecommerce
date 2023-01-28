package com.ecommerce.warehouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "warehouse infomation")
public class WarehouseInfoDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "ID")
	private Long id;

	@ApiModelProperty(value = "Warehouse name")
	private String name;

	@ApiModelProperty(value = "Warehouse address")
	private String address;

	@ApiModelProperty(value = "zipcode")
	private String zipcode;


}