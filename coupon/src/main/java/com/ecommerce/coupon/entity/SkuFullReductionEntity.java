package com.ecommerce.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品满减信息
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@Data
@TableName("sms_sku_full_reduction")
public class SkuFullReductionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

			/**
		 * id
		 */
				@TableId
			private Long id;
			/**
		 * spu_id
		 */
			private Long skuId;
			/**
		 * 满多少
		 */
			private BigDecimal fullPrice;
			/**
		 * 减多少
		 */
			private BigDecimal reducePrice;
			/**
		 * 是否参与其他优惠
		 */
			private Integer addOther;
	}