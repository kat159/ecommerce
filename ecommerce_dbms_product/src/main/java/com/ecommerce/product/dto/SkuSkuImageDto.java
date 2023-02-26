package com.ecommerce.product.dto;

import com.ecommerce.common.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "join table")
public class SkuSkuImageDto extends BaseDto<SkuSkuImageDto>
		implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "")
	private Long skuId;

	@ApiModelProperty(value = "")
	private Long skuImageId;

	@ApiModelProperty(value = "")
	private Long id;

	@ApiModelProperty(value = "")
	private Integer sort;


}