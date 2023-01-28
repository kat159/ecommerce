package com.ecommerce.coupon.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "Subject related products")
public class HomepageSubjectProductDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "Subject Name")
	private String name;

	@ApiModelProperty(value = "Subject ID")
	private Long subjectId;

	@ApiModelProperty(value = "Product ID")
	private Long productId;

	@ApiModelProperty(value = "Sort")
	private Integer sort;


}