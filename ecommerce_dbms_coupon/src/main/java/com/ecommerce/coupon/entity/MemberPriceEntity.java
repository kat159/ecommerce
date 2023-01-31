package com.ecommerce.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("member_price")
public class MemberPriceEntity {

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
     * Member level ID
     */
		private Long memberLevelId;
    /**
     * Member level name
     */
		private String memberLevelName;
    /**
     * Price for member
     */
		private BigDecimal memberPrice;
    /**
     * Can be combined with other discounts [0-Cannot be combined, 1-Can be combined]
     */
		private Integer stackable;
}