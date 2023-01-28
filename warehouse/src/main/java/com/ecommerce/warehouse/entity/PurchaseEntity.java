package com.ecommerce.warehouse.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("purchase")
public class PurchaseEntity {

    /**
     * Purchase ID
     */
		@TableId
		private Long id;
    /**
     * ID of the person making the purchase
     */
		private Long assigneeId;
    /**
     * Name of the person making the purchase
     */
		private String assigneeName;
    /**
     * tele number of the person making the purchase
     */
		private String assigneeTele;
    /**
     * Priority
     */
		private Integer priority;
    /**
     * Status
     */
		private Integer status;
    /**
     * Warehouse ID
     */
		private Long warehouseId;
    /**
     * Total amount
     */
		private BigDecimal amount;
    /**
     * Date created
     */
		private Date createDate;
    /**
     * Date updated
     */
		private Date updateDate;
}