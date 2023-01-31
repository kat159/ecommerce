package com.ecommerce.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("sku_volume_discount")
public class SkuVolumeDiscountEntity {

    /**
     * id
     */
		@TableId
		private Long id;
    /**
     * SKU ID
     */
		private Long skuId;
    /**
     * volume threshold to apply discounted price
     */
		private BigDecimal threshold;
    /**
     * discounted price
     */
		private BigDecimal discountedPrice;
    /**
     * Whether can be combined with other offer
     */
		private Integer combinable;
}