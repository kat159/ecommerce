package com.ecommerce.order.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



@Data
@ApiModel(value = "order operation record")
public class OrderOperationRecordDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "order id")
	private Long orderId;

	@ApiModelProperty(value = "operator [user; system; backend administrator]")
	private String operator;

	@ApiModelProperty(value = "operation time")
	private Date date;

	@ApiModelProperty(value = "order status [0->pending payment; 1->pending shipment; 2->shipped; 3->completed; 4->closed; 5->invalid order]")
	private Integer orderStatus;

	@ApiModelProperty(value = "note")
	private String note;


}