package com.ecommerce.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("refund_info")
public class RefundInfoEntity {

    /**
     * ID
     */
		@TableId
		private Long id;
    /**
     * Refund Order id
     */
		private Long orderId;
    /**
     * Refund Amount
     */
		private BigDecimal refundAmount;
    /**
     * Refund Transaction Serial Number
     */
		private String refundSn;
    /**
     * Refund Status
     */
		private Integer refundStatus;
    /**
     * Refund Channel [1-debit card, 2-credit card, 3-paypal, 4-others]
     */
		private Integer refundChannel;
    /**
     * 
     */
		private String refundContent;
}