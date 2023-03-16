package com.ecommerce.product.dto;

import com.ecommerce.common.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
@ApiModel(value = "sku")
public class SkuDto extends BaseDto<SkuDto>
		implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;
	private Long productId;
	private String name;
	private String description;
	private String defaultImg;
	private String title;
	private String subtitle;
	private BigDecimal price;
	private Long saleCount;
	private BigDecimal primeDiscount;
	private BigDecimal giftCardBonus;
	private Long stock;
	private BigDecimal rating;
	private Integer status;
	private BigDecimal finalPrice;
}