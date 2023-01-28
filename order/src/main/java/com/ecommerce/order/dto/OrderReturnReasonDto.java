package com.ecommerce.order.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



@Data
@ApiModel(value = "Return reasons")
public class OrderReturnReasonDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "Return reason type")
	private String reasonType;

	@ApiModelProperty(value = "Return reason detail")
	private String detail;

	@ApiModelProperty(value = "Sort")
	private Integer sort;

	@ApiModelProperty(value = "status")
	private Integer status;

	@ApiModelProperty(value = "date")
	private Date date;


}