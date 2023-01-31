package com.ecommerce.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("order_return_application")
public class OrderReturnApplicationEntity {

    /**
     * id
     */
		@TableId
		private Long id;
    /**
     * order_id
     */
		private Long orderId;
    /**
     * skuid
     */
		private Long skuId;
    /**
     * order series num
     */
		private String orderSn;
    /**
     * application date
     */
		private Date date;
    /**
     * applicant username
     */
		private String username;
    /**
     * refund amount
     */
		private BigDecimal refundAmount;
    /**
     * refund receriver name
     */
		private String refundName;
    /**
     * refund receiver tele num
     */
		private String refundTele;
    /**
     * [0->Pending; 1->Returning; 2->Completed; 3->Rejected]
     */
		private Integer status;
    /**
     * The time when the application was processed
     */
		private Date processDate;
    /**
     * Product image
     */
		private String skuImg;
    /**
     * Product name
     */
		private String skuName;
    /**
     * Product brand
     */
		private String skuBrand;
    /**
     * Product sales attributes (JSON)
     */
		private String skuAttrsVals;
    /**
     * Return quantity
     */
		private Integer skuCount;
    /**
     * Product unit price
     */
		private BigDecimal skuPrice;
    /**
     * Product actual payment unit price
     */
		private BigDecimal skuFinalPrice;
    /**
     * Reason
     */
		private String reason;
    /**
     * Description
     */
		private String description;
    /**
     * proof pictures, separated by commas
     */
		private String proofImgs;
    /**
     * Processing notes
     */
		private String processNote;
    /**
     * Processing personnel
     */
		private String proccessor;
    /**
     * Receiver
     */
		private String consignee;
    /**
     * date when received 
     */
		private Date packageArriveDate;
    /**
     * package note
     */
		private String packageNote;
    /**
     * Receiver's phone
     */
		private String consigneePhone;
    /**
     * receiving address
     */
		private String consigneeAddress;
}