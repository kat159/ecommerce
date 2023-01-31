package com.ecommerce.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("order_item")
public class OrderItemEntity {

    /**
     * id
     */
		@TableId
		private Long id;
    /**
     * order id
     */
		private Long orderId;
    /**
     * order serial number
     */
		private String orderSn;
    /**
     * product id
     */
		private Long productId;
    /**
     * product name
     */
		private String productName;
    /**
     * product img
     */
		private String productImg;
    /**
     * brand
     */
		private String productBrand;
    /**
     * product category id
     */
		private Long categoryId;
    /**
     * product sku number
     */
		private Long skuId;
    /**
     * product sku name
     */
		private String skuName;
    /**
     * product sku picture
     */
		private String skuImg;
    /**
     * product sku price
     */
		private BigDecimal skuPrice;
    /**
     * quantity of product purchased
     */
		private Integer skuQuantity;
    /**
     * JSON of product sales attributes
     */
		private String skuAttributeValues;
    /**
     * amount of promotion breakdown
     */
		private BigDecimal discountAmount;
    /**
     * amount of coupon discount breakdown
     */
		private BigDecimal couponAmount;
    /**
     * amount of points discount breakdown
     */
		private BigDecimal rewardAmount;
    /**
     * the breakdown amount after discounts
     */
		private BigDecimal paymentAmount;
    /**
     * gift points
     */
		private Integer giftRewardPoints;
    /**
     * gift points
     */
		private Integer giftMembershipPoint;
}