package com.ecommerce.coupon.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



@Data
@ApiModel(value = "Promotion")
public class PromotionDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "Promotion Title")
	private String title;

	@ApiModelProperty(value = "Start date")
	private Date startDate;

	@ApiModelProperty(value = "End date")
	private Date endDate;

	@ApiModelProperty(value = "Status")
	private Integer status;

	@ApiModelProperty(value = "Create date")
	private Date createDate;

	@ApiModelProperty(value = "Creator")
	private Long creatorId;


}