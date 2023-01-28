package com.ecommerce.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("promotion_sku")
public class PromotionSkuEntity {

    /**
     * id
     */
		@TableId
		private Long id;
    /**
     * Promotion ID
     */
		private Long promotionId;
    /**
     * Promotion session ID
     */
		private Long promotionSessionId;
    /**
     * SKU ID
     */
		private Long skuId;
    /**
     * Special price
     */
		private BigDecimal specialPrice;
    /**
     * Seckill total quantity
     */
		private BigDecimal limitTotalNumber;
    /**
     * Limit per person
     */
		private BigDecimal limitNumberPerMember;
    /**
     * Sort order
     */
		private Integer sort;
}