package com.ecommerce.product.dto;

import com.ecommerce.common.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



@Data
@ApiModel(value = "sku review")
public class SkuReviewDto extends BaseDto<SkuReviewDto>
		implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "sku id")
	private Long skuId;

	@ApiModelProperty(value = "product name")
	private String productName;

	@ApiModelProperty(value = "member nickname")
	private String memberNickname;

	@ApiModelProperty(value = "rating[0-5]")
	private Integer rating;

	@ApiModelProperty(value = "how many members found the review is helpful")
	private Integer thumbsUp;

	@ApiModelProperty(value = "create date")
	private Date createDate;

	@ApiModelProperty(value = "comment status [0-deleted, 1-displayed, 2-archived]")
	private Integer status;

	@ApiModelProperty(value = "attribute combination when purchasing")
	private String productAttributes;

	@ApiModelProperty(value = "number of replies")
	private Integer replyCount;

	@ApiModelProperty(value = "images/videos [json data; [{type: file type, url: resource path}]]")
	private String resources;

	@ApiModelProperty(value = "content")
	private String content;

	@ApiModelProperty(value = "user avatar")
	private String memberAvatar;

	@ApiModelProperty(value = "comment type [0 - direct comment on product, 1 - reply to comment]")
	private Integer commentType;


}