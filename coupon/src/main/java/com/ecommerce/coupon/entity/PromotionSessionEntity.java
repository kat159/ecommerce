package com.ecommerce.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("promotion_session")
public class PromotionSessionEntity {

    /**
     * id
     */
		@TableId
		private Long id;
    /**
     * Session name
     */
		private String name;
    /**
     * Daily start time
     */
		private Date startDate;
    /**
     * Daily end time
     */
		private Date endDate;
    /**
     * Enabled status
     */
		private Integer status;
    /**
     * Creation sate
     */
		private Date createDate;
}