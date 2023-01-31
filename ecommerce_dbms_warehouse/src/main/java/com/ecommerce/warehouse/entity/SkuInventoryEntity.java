package com.ecommerce.warehouse.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sku_inventory")
public class SkuInventoryEntity {

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
     * Warehouse ID
     */
		private Long warehouseId;
    /**
     * Stock quantity
     */
		private Integer stockCount;
    /**
     * SKU name
     */
		private String skuName;
    /**
     * Locked stock
     */
		private Integer stockLockedCount;
}