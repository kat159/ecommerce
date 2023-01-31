package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("product_comment")
public class ProductCommentEntity {

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
     * product id
     */
		private Long productId;
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
     * thumbs-up by other members
     */
		private Integer thumbsUp;
    /**
     * thumbs-down by other members
     */
		private Integer thumbsDowm;
    /**
     * creation time
     */
		private Date createTime;
    /**
     * comment status [0-deleted, 1-displayed, 2-archived]
     */
		private Integer status;
    /**
     * attribute combination when purchasing
     */
		private String productAttributes;
    /**
     * number of likes
     */
		private Integer likesCount;
    /**
     * number of replies
     */
		private Integer replyCount;
    /**
     * comment images/videos [json data; [{type: file type, url: resource path}]]
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