package com.ecommerce.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 优惠券分类关联
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@Data
@TableName("sms_coupon_spu_category_relation")
public class CouponSpuCategoryRelationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

			/**
		 * id
		 */
				@TableId
			private Long id;
			/**
		 * 优惠券id
		 */
			private Long couponId;
			/**
		 * 产品分类id
		 */
			private Long categoryId;
			/**
		 * 产品分类名称
		 */
			private String categoryName;
	}