package com.ecommerce.product.dto;

import com.ecommerce.common.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "")
public class SkuReviewReplyDto extends BaseDto<SkuReviewReplyDto>
		implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "review id")
	private Long skuReviewId;

	@ApiModelProperty(value = "reply id")
	private Long replyId;


}