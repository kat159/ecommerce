package com.ecommerce.warehouse.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("warehouse_info")
public class WarehouseInfoEntity {

    /**
     * ID
     */
		@TableId
		private Long id;
    /**
     * Warehouse name
     */
		private String name;
    /**
     * Warehouse address
     */
		private String address;
    /**
     * zipcode
     */
		private String zipcode;
}