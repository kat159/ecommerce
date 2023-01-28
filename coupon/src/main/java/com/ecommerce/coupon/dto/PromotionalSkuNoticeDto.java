package com.ecommerce.coupon.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



@Data
@ApiModel(value = "Promotional Sku Notification Subscription")
public class PromotionalSkuNoticeDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "Member ID")
	private Long memberId;

	@ApiModelProperty(value = "SKU ID")
	private Long skuId;

	@ApiModelProperty(value = "Promotion session ID")
	private Long sessionId;

	@ApiModelProperty(value = "Subscription date")
	private Date subcribeDate;

	@ApiModelProperty(value = "The time when the notice sent")
	private Date noticeDate;

	@ApiModelProperty(value = "Notice approach [0-SMS, 1-Email]")
	private Integer noticeApproach;


}