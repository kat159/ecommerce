package com.ecommerce.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("collected_coupon_status")
public class CollectedCouponStatusEntity {

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
     * Member ID
     */
		private Long memberId;
    /**
     * Member Name
     */
		private String memberNickname;
    /**
     * Acquisition Method [0-> Backend Giveaway; 1-> Active Reception]
     */
		private Integer collectionType;
    /**
     * Creation Time
     */
		private Date createTime;
    /**
     * Use Status [0-> Not Used; 1-> Used; 2-> Expired]
     */
		private Integer status;
    /**
     * Date when used
     */
		private Date usedDate;
    /**
     * Order ID of the order paid with this coupon
     */
		private Long orderId;
    /**
     * Order series numbe of the order paid with this couponr
     */
		private Long orderSn;
}