package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ecommerce.common.entity.BaseEntity;
import lombok.Data;

@Data
@TableName("sku_review_reply")
public class SkuReviewReplyEntity extends BaseEntity<SkuReviewReplyEntity> {

    /**
     * id
     */
		@TableId
		private Long id;
    /**
     * review id
     */
		private Long skuReviewId;
    /**
     * reply id
     */
		private Long replyId;
}