package com.ecommerce.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("product_reward")
public class ProductRewardEntity {

    /**
     * id
     */
		@TableId
		private Long id;
    /**
     * 
     */
		private Long productId;
    /**
     * membership point
     */
		private BigDecimal membershipPoint;
    /**
     * reward point
     */
		private BigDecimal rewardPoint;
    /**
     * Reward effectiveness [1111 (four states from right to left); 
	0 - no promotion, membership_point gained or not; 
	1 - no promotion, reward_point gained or not; 
	2 - promotion, membership_point gained or not; 
	3 - promotion, reward_point gained or not 
    [state 0: not gained, 1: gained]]
     */
		private Integer effectiveness;
}