package com.ecommerce.warehouse.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("purchase_detail")
public class PurchaseDetailEntity {

    /**
     * 
     */
		@TableId
		private Long id;
    /**
     * Purchase ID
     */
		private Long purchaseId;
    /**
     * ID of the purchased item
     */
		private Long skuId;
    /**
     * Quantity purchased
     */
		private Integer skuNum;
    /**
     * Purchase amount
     */
		private BigDecimal skuPrice;
    /**
     * Warehouse ID
     */
		private Long warehouseId;
    /**
     * Status [0: new, 1: assigned, 2: in progress, 3: completed, 4: purchase failed]
     */
		private Integer status;
}