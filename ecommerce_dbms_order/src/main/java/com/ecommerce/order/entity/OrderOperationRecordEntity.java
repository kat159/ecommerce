package com.ecommerce.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("order_operation_record")
public class OrderOperationRecordEntity {

    /**
     * id
     */
		@TableId
		private Long id;
    /**
     * order id
     */
		private Long orderId;
    /**
     * operator [user; system; backend administrator]
     */
		private String operator;
    /**
     * operation time
     */
		private Date date;
    /**
     * order status [0->pending payment; 1->pending shipment; 2->shipped; 3->completed; 4->closed; 5->invalid order]
     */
		private Integer orderStatus;
    /**
     * note
     */
		private String note;
}