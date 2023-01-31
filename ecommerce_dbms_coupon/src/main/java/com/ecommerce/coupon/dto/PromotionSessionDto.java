package com.ecommerce.coupon.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



@Data
@ApiModel(value = "Promotion Session")
public class PromotionSessionDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "Session name")
	private String name;

	@ApiModelProperty(value = "Daily start time")
	private Date startDate;

	@ApiModelProperty(value = "Daily end time")
	private Date endDate;

	@ApiModelProperty(value = "Enabled status")
	private Integer status;

	@ApiModelProperty(value = "Creation sate")
	private Date createDate;


}