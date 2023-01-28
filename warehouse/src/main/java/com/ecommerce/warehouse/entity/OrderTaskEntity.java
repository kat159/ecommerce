package com.ecommerce.warehouse.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("order_task")
public class OrderTaskEntity {

    /**
     * ID
     */
		@TableId
		private Long id;
    /**
     * Order ID
     */
		private Long orderId;
    /**
     * Order serial number
     */
		private String orderSn;
    /**
     * Recipient
     */
		private String consignee;
    /**
     * Recipient telephone
     */
		private String consigneeTel;
    /**
     * Delivery address
     */
		private String deliveryAddress;
    /**
     * Order notet
     */
		private String orderNote;
    /**
     * Payment method [1: online payment, 2: pay on delivery]
     */
		private Integer paymentMethod;
    /**
     * Task status
     */
		private Integer status;
    /**
     * Order description
     */
		private String description;
    /**
     * Tracking number
     */
		private String trackingNumber;
    /**
     * Date created
     */
		private Date createDate;
    /**
     * Warehouse ID
     */
		private Long warehouseId;
    /**
     * Task note
     */
		private String taskNote;
}