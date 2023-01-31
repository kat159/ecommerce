package com.ecommerce.coupon.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



@Data
@ApiModel(value = "Homepage Carousel Ad")
public class HomepageAdDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "Name")
	private String name;

	@ApiModelProperty(value = "Image URL")
	private String pic;

	@ApiModelProperty(value = "Start Time")
	private Date startTime;

	@ApiModelProperty(value = "End Time")
	private Date endTime;

	@ApiModelProperty(value = "Status")
	private Integer status;

	@ApiModelProperty(value = "Click Count")
	private Integer clickCount;

	@ApiModelProperty(value = "Ad redirected Link")
	private String url;

	@ApiModelProperty(value = "remark")
	private String remark;

	@ApiModelProperty(value = "Sort")
	private Integer sort;

	@ApiModelProperty(value = "Publisher")
	private Long publisherId;

	@ApiModelProperty(value = "Person who censored the ad")
	private Long censorId;


}