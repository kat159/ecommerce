package com.ecommerce.product.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "product images")
public class ProductImagesDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "product id")
	private Long productId;

	@ApiModelProperty(value = "image name")
	private String imgName;

	@ApiModelProperty(value = "image url")
	private String imgUrl;

	@ApiModelProperty(value = "sort order")
	private Integer imgSort;

	@ApiModelProperty(value = "whether it is default image")
	private Integer defaultImg;


}