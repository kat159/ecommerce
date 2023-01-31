package com.ecommerce.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("order_return_reason")
public class OrderReturnReasonEntity {

    /**
     * id
     */
		@TableId
		private Long id;
    /**
     * Return reason type
     */
		private String reasonType;
    /**
     * Return reason detail
     */
		private String detail;
    /**
     * Sort
     */
		private Integer sort;
    /**
     * status
     */
		private Integer status;
    /**
     * date
     */
		private Date date;
}