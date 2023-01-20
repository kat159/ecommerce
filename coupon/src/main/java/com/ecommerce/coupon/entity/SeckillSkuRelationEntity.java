package com.ecommerce.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 秒杀活动商品关联
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@Data
@TableName("sms_seckill_sku_relation")
public class SeckillSkuRelationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

			/**
		 * id
		 */
				@TableId
			private Long id;
			/**
		 * 活动id
		 */
			private Long promotionId;
			/**
		 * 活动场次id
		 */
			private Long promotionSessionId;
			/**
		 * 商品id
		 */
			private Long skuId;
			/**
		 * 秒杀价格
		 */
			private BigDecimal seckillPrice;
			/**
		 * 秒杀总量
		 */
			private BigDecimal seckillCount;
			/**
		 * 每人限购数量
		 */
			private BigDecimal seckillLimit;
			/**
		 * 排序
		 */
			private Integer seckillSort;
	}