package com.ecommerce.warehouse.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 库存工作单
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-19
 */
@Data
@TableName("wms_ware_order_task_detail")
public class WareOrderTaskDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

			/**
		 * id
		 */
				@TableId
			private Long id;
			/**
		 * sku_id
		 */
			private Long skuId;
			/**
		 * sku_name
		 */
			private String skuName;
			/**
		 * 购买个数
		 */
			private Integer skuNum;
			/**
		 * 工作单id
		 */
			private Long taskId;
	}