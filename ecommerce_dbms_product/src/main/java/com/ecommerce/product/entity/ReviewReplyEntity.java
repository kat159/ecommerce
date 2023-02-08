package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ecommerce.common.entity.BaseEntity;
import lombok.Data;

@Data
@TableName("review_reply")
public class ReviewReplyEntity extends BaseEntity<ReviewReplyEntity> {

    /**
     * id
     */
		@TableId
		private Long id;
    /**
     * comment id
     */
		private Long reviewId;
    /**
     * reply id
     */
		private Long replyId;
}