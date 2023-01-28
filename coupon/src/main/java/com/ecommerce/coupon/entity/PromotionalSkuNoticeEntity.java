package com.ecommerce.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("promotional_sku_notice")
public class PromotionalSkuNoticeEntity {

    /**
     * id
     */
		@TableId
		private Long id;
    /**
     * Member ID
     */
		private Long memberId;
    /**
     * SKU ID
     */
		private Long skuId;
    /**
     * Promotion session ID
     */
		private Long sessionId;
    /**
     * Subscription date
     */
		private Date subcribeDate;
    /**
     * The time when the notice sent
     */
		private Date noticeDate;
    /**
     * Notice approach [0-SMS, 1-Email]
     */
		private Integer noticeApproach;
}