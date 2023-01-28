package com.ecommerce.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("coupon")
public class CouponEntity {

    /**
     * ID
     */
		@TableId
		private Long id;
    /**
     * [0-> Whole Store Gift Coupon; 1-> Member Gift Coupon; 2-> Shopping Gift Coupon; 3-> Registration Gift Coupon]
     */
		private Integer issueType;
    /**
     * Coupon Image
     */
		private String img;
    /**
     * Coupon Name
     */
		private String name;
    /**
     * Quantity
     */
		private Integer count;
    /**
     * Amount
     */
		private BigDecimal amount;
    /**
     * Number of Coupons per Person
     */
		private Integer limitQuantity;
    /**
     * Minimum Threshold for Use
     */
		private BigDecimal limitMembershipPoint;
    /**
     * Use Type [0-> Whole Store General; 1-> Specific Category; 2-> Specific Product]
     */
		private Integer limitRange;
    /**
     * Member Level Available [0-> No Limit, Other- Corresponding Level]
     */
		private Integer limitMemberLevel;
    /**
     * Start time/date
     */
		private Date availableStartDate;
    /**
     * End time/date
     */
		private Date availableEndDate;
    /**
     * remark
     */
		private String remark;
    /**
     * Published Number
     */
		private Integer publishedNumber;
    /**
     * Used number
     */
		private Integer usedNumber;
    /**
     * Received Quantity
     */
		private Integer collectedNumber;
    /**
     * Start time/date to collect
     */
		private Date collectionStartDate;
    /**
     * Last time/date to collect
     */
		private Date collectionEndDate;
    /**
     * coupon Code
     */
		private String code;
    /**
     * Publish Status [0- Not Published, 1- Published]
     */
		private Integer publishStatus;
}