package com.ecommerce.product.dto;

import com.ecommerce.common.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "join table")
public class CategoryBrandDto extends BaseDto<CategoryBrandDto>
		implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "")
	private Long id;

	@ApiModelProperty(value = "brand id")
	private Long brandId;

	@ApiModelProperty(value = "category id")
	private Long categoryId;

	@ApiModelProperty(value = "")
	private String brandName;

	@ApiModelProperty(value = "")
	private String categoryName;


}