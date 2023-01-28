package com.ecommerce.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("payment_info")
public class PaymentInfoEntity {

    /**
     * ID
     */
		@TableId
		private Long id;
    /**
     * Order Number (External Business Number)
     */
		private String orderSn;
    /**
     * Order ID
     */
		private Long orderId;
    /**
     * transaction Serial Number
     */
		private String transactionSn;
    /**
     * Total Payment Amount
     */
		private BigDecimal totalAmount;
    /**
     * Transaction Content
     */
		private String content;
    /**
     * Payment Status
     */
		private String paymentStatus;
    /**
     * Creation date
     */
		private Date createDate;
    /**
     * Confirmation date
     */
		private Date confirmDate;
    /**
     * Callback Content
     */
		private String callbackContent;
    /**
     * Callback Time
     */
		private Date callbackTime;
}