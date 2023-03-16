package com.ecommerce.member.dto;

import com.ecommerce.common.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



@Data
@ApiModel(value = "member favorite_product")
public class FavoriteProductDto extends BaseDto<FavoriteProductDto>
		implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "ID")
	private Long id;

	@ApiModelProperty(value = "Member ID")
	private Long memberId;

	@ApiModelProperty(value = "Product ID")
	private Long productId;

	@ApiModelProperty(value = "Product name")
	private String productName;

	@ApiModelProperty(value = "Product image")
	private String productImg;

	@ApiModelProperty(value = "Date added to favorites")
	private Date addDate;


}