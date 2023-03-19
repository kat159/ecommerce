package com.ecommerce.order.dto;


import lombok.Data;

@Data
public class ManageRefundRequestDto {
    private Long refundRequestId;
    private Integer isApproved;  // 1-approve
    private String username;
    private String reason;
}
