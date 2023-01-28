package com.ecommerce.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("statistics")
public class StatisticsEntity {

    /**
     * ID
     */
		@TableId
		private Long id;
    /**
     * Member ID
     */
		private Long memberId;
    /**
     * Accumulated payment
     */
		private BigDecimal accumPayment;
    /**
     * Accumulated discount Amount
     */
		private BigDecimal accumDiscount;
    /**
     * Order Count
     */
		private Integer numOrder;
    /**
     * Coupon Count
     */
		private Integer numCoupon;
    /**
     * Comment Count
     */
		private Integer numComment;
    /**
     * Return Order Count
     */
		private Integer numReturnOrder;
    /**
     * Login Count
     */
		private Integer numLogin;
    /**
     * Attention Count
     */
		private Integer numAttend;
    /**
     * Fans Count
     */
		private Integer numFans;
    /**
     * Refer friend Count
     */
		private Integer numRefer;
}