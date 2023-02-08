package com.ecommerce.product.dto;

import com.ecommerce.common.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "product images")
public class ProductImageDto extends BaseDto<ProductImageDto>
		implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "product id")
	private Long productId;

	@ApiModelProperty(value = "image name")
	private String name;

	@ApiModelProperty(value = "image url")
	private String url;

	@ApiModelProperty(value = "assume List[img1, img2, img3], display_order=index")
	private Integer displayOrder;

	@ApiModelProperty(value = "whether it is default image")
	private Integer isDefault;


}