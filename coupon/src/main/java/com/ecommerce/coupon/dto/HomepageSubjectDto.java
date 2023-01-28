package com.ecommerce.coupon.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "Homepage Subjects [There will be many subjects on the homepage, each subject links to a new page, displaying subject product information]")
public class HomepageSubjectDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "Subject Name")
	private String name;

	@ApiModelProperty(value = "Subject Title")
	private String title;

	@ApiModelProperty(value = "Subject Subtitle")
	private String subTitle;

	@ApiModelProperty(value = "Display Status")
	private Integer displayStatus;

	@ApiModelProperty(value = "Detail Link")
	private String link;

	@ApiModelProperty(value = "Sort")
	private Integer sort;

	@ApiModelProperty(value = "Subject Image URL")
	private String img;


}