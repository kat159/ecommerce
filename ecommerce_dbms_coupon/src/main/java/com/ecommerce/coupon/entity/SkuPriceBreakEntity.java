package com.ecommerce.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("sku_price_break")
public class SkuPriceBreakEntity {

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
     * amount threshold to apply discounted price
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