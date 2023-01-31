package com.ecommerce.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("coupon_applied_product_category")
public class CouponAppliedProductCategoryEntity {

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
     * Product Category ID
     */
		private Long categoryId;
    /**
     * Product Category Name
     */
		private String categoryName;
}