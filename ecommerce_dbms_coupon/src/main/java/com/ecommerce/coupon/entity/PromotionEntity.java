package com.ecommerce.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("promotion")
public class PromotionEntity {

    /**
     * id
     */
		@TableId
		private Long id;
    /**
     * Promotion Title
     */
		private String title;
    /**
     * Start date
     */
		private Date startDate;
    /**
     * End date
     */
		private Date endDate;
    /**
     * Status
     */
		private Integer status;
    /**
     * Create date
     */
		private Date createDate;
    /**
     * Creator
     */
		private Long creatorId;
}