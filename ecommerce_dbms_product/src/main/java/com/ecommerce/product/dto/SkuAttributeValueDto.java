package com.ecommerce.product.dto;

import com.ecommerce.common.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "")
public class SkuAttributeValueDto extends BaseDto<SkuAttributeValueDto>
		implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "sku id")
	private Long skuId;

	@ApiModelProperty(value = "attribute id")
	private Long attributeId;

	@ApiModelProperty(value = "")
	private String attributeName;

	@ApiModelProperty(value = "")
	private String attributeValue;

	@ApiModelProperty(value = "assume List[img1, img2, img3], sort=index")
	private Integer sort;


}