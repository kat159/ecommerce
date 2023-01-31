package com.ecommerce.warehouse.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("order_task_detail")
public class OrderTaskDetailEntity {

    /**
     * ID
     */
		@TableId
		private Long id;
    /**
     * SKU ID
     */
		private Long skuId;
    /**
     * SKU name
     */
		private String skuName;
    /**
     * Number of purchased items
     */
		private Integer skuNum;
    /**
     * Task ID
     */
		private Long taskId;
}