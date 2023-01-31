package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("comment_reply")
public class CommentReplyEntity {

    /**
     * id
     */
		@TableId
		private Long id;
    /**
     * comment id
     */
		private Long commentId;
    /**
     * reply id
     */
		private Long replyId;
}