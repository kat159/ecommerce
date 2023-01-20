package com.ecommerce.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 退款信息
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@Data
@TableName("oms_refund_info")
public class RefundInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

			/**
		 * id
		 */
				@TableId
			private Long id;
			/**
		 * 退款的订单
		 */
			private Long orderReturnId;
			/**
		 * 退款金额
		 */
			private BigDecimal refund;
			/**
		 * 退款交易流水号
		 */
			private String refundSn;
			/**
		 * 退款状态
		 */
			private Integer refundStatus;
			/**
		 * 退款渠道[1-支付宝，2-微信，3-银联，4-汇款]
		 */
			private Integer refundChannel;
			/**
		 * 
		 */
			private String refundContent;
	}