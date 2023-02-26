package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ecommerce.common.entity.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName("sku_review")
public class SkuReviewEntity extends BaseEntity<SkuReviewEntity> {

    /**
     * id
     */
		@TableId
		private Long id;
    /**
     * sku id
     */
		private Long skuId;
    /**
     * product name
     */
		private String productName;
    /**
     * member nickname
     */
		private String memberNickname;
    /**
     * rating[0-5]
     */
		private Integer rating;
    /**
     * how many members found the review is helpful
     */
		private Integer thumbsUp;
    /**
     * create date
     */
		private Date createDate;
    /**
     * comment status [0-deleted, 1-displayed, 2-archived]
     */
		private Integer status;
    /**
     * attribute combination when purchasing
     */
		private String productAttributes;
    /**
     * number of replies
     */
		private Integer replyCount;
    /**
     * images/videos [json data; [{type: file type, url: resource path}]]
     */
		private String resources;
    /**
     * content
     */
		private String content;
    /**
     * user avatar
     */
		private String memberAvatar;
    /**
     * comment type [0 - direct comment on product, 1 - reply to comment]
     */
		private Integer commentType;
}