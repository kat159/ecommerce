package com.ecommerce.order.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "Order configuration information")
public class OrderSettingDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "promotion order time to live(minutes)")
	private Integer promotionOrderTtl;

	@ApiModelProperty(value = "Gneral order tiem to live (minutes)")
	private Integer generalOrderTtl;

	@ApiModelProperty(value = "Auto-positive comment time after order completion (days)")
	private Integer overtimeAutoComment;

	@ApiModelProperty(value = "Member level [0-unlimited member level, all general; other-corresponding other member level]")
	private Integer memberLevel;


}