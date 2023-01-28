package com.ecommerce.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("coupon_applied_product")
public class CouponAppliedProductEntity {

    /**
     * ID
     */
		@TableId
		private Long id;
    /**
     * Coupon ID
     */
		private Long couponId;
    /**
     * Product ID
     */
		private Long productId;
    /**
     * Product Name
     */
		private String productName;
}