package com.ecommerce.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("order_setting")
public class OrderSettingEntity {

    /**
     * id
     */
		@TableId
		private Long id;
    /**
     * promotion order time to live(minutes)
     */
		private Integer promotionOrderTtl;
    /**
     * Gneral order tiem to live (minutes)
     */
		private Integer generalOrderTtl;
    /**
     * Auto-positive comment time after order completion (days)
     */
		private Integer overtimeAutoComment;
    /**
     * Member level [0-unlimited member level, all general; other-corresponding other member level]
     */
		private Integer memberLevel;
}