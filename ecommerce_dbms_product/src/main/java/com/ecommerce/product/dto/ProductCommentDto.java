package com.ecommerce.product.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



@Data
@ApiModel(value = "product review")
public class ProductCommentDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "sku id")
	private Long skuId;

	@ApiModelProperty(value = "product id")
	private Long productId;

	@ApiModelProperty(value = "product name")
	private String productName;

	@ApiModelProperty(value = "member nickname")
	private String memberNickname;

	@ApiModelProperty(value = "rating[0-5]")
	private Integer rating;

	@ApiModelProperty(value = "thumbs-up by other members")
	private Integer thumbsUp;

	@ApiModelProperty(value = "thumbs-down by other members")
	private Integer thumbsDowm;

	@ApiModelProperty(value = "creation time")
	private Date createTime;

	@ApiModelProperty(value = "comment status [0-deleted, 1-displayed, 2-archived]")
	private Integer status;

	@ApiModelProperty(value = "attribute combination when purchasing")
	private String productAttributes;

	@ApiModelProperty(value = "number of likes")
	private Integer likesCount;

	@ApiModelProperty(value = "number of replies")
	private Integer replyCount;

	@ApiModelProperty(value = "comment images/videos [json data; [{type: file type, url: resource path}]]")
	private String resources;

	@ApiModelProperty(value = "content")
	private String content;

	@ApiModelProperty(value = "user avatar")
	private String memberAvatar;

	@ApiModelProperty(value = "comment type [0 - direct comment on product, 1 - reply to comment]")
	private Integer commentType;


}