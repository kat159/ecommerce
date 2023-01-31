package com.ecommerce.coupon.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@ApiModel(value = "Information of coupon of different types")
public class CouponDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "ID")
	private Long id;

	@ApiModelProperty(value = "[0-> Whole Store Gift Coupon; 1-> Member Gift Coupon; 2-> Shopping Gift Coupon; 3-> Registration Gift Coupon]")
	private Integer issueType;

	@ApiModelProperty(value = "Coupon Image")
	private String img;

	@ApiModelProperty(value = "Coupon Name")
	private String name;

	@ApiModelProperty(value = "Quantity")
	private Integer count;

	@ApiModelProperty(value = "Amount")
	private BigDecimal amount;

	@ApiModelProperty(value = "Number of Coupons per Person")
	private Integer limitQuantity;

	@ApiModelProperty(value = "Minimum Threshold for Use")
	private BigDecimal limitMembershipPoint;

	@ApiModelProperty(value = "Use Type [0-> Whole Store General; 1-> Specific Category; 2-> Specific Product]")
	private Integer limitRange;

	@ApiModelProperty(value = "Member Level Available [0-> No Limit, Other- Corresponding Level]")
	private Integer limitMemberLevel;

	@ApiModelProperty(value = "Start time/date")
	private Date availableStartDate;

	@ApiModelProperty(value = "End time/date")
	private Date availableEndDate;

	@ApiModelProperty(value = "remark")
	private String remark;

	@ApiModelProperty(value = "Published Number")
	private Integer publishedNumber;

	@ApiModelProperty(value = "Used number")
	private Integer usedNumber;

	@ApiModelProperty(value = "Received Quantity")
	private Integer collectedNumber;

	@ApiModelProperty(value = "Start time/date to collect")
	private Date collectionStartDate;

	@ApiModelProperty(value = "Last time/date to collect")
	private Date collectionEndDate;

	@ApiModelProperty(value = "coupon Code")
	private String code;

	@ApiModelProperty(value = "Publish Status [0- Not Published, 1- Published]")
	private Integer publishStatus;


}