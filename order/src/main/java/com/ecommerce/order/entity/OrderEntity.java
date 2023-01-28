package com.ecommerce.order.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("`order`")
public class OrderEntity {

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * member id
     */

    private Long memberId;
    /**
     * order number
     */
    private String orderSn;
    /**
     * coupon used
     */
    private Long couponId;
    /**
     * create time
     */
    private Date createTime;
    /**
     * username
     */
    private String memberUsername;
    /**
     * total order amount
     */
    private BigDecimal totalAmount;
    /**
     * amount to pay
     */
    private BigDecimal payAmount;
    /**
     * freight amount
     */
    private BigDecimal freightAmount;
    /**
     * promotion amount (special price, member price, price break, volume discount)
     */
    private BigDecimal discountAmountPromotion;
    /**
     * reduced amount by reward point
     */
    private BigDecimal discountAmountRewardPoint;
    /**
     * coupon amount
     */
    private BigDecimal discountAmountCoupon;
    /**
     * discount amount adjusted by admin
     */
    private BigDecimal discountAmountAdmin;
    /**
     * payment method [0->debit card; 1->credit card; 2->paypal; 3->cash on delivery; 4->others]
     */
    private Integer paymentMethod;
    /**
     * order source [0->website; 1->app]
     */
    private Integer paymentApp;
    /**
     * order status [0->not paid; 1->not shipped; 2->shipped; 3->completed; 4->closed; 5->invalid order]
     */
    private Integer status;
    /**
     * delivery company
     */
    private String deliveryCompany;
    /**
     * tracking_number
     */
    private String deliveryTrackingNumber;
    /**
     * auto confirm time (days)
     */
    private Integer autoConfirmDay;
    /**
     * integration earned
     */
    private Integer integration;
    /**
     * membership_point earned
     */
    private Integer membershipPoint;
    /**
     * bill/invoice type [0->no invoice; 1->electronic invoice; 2->paper invoice]
     */
    private Integer billType;
    /**
     * bill/invoice header
     */
    private String billHeader;
    /**
     * bill/invoice content
     */
    private String billContent;
    /**
     * bill/invoice receiver phone
     */
    private String billReceiverPhone;
    /**
     * bill/invoice receiver email
     */
    private String billReceiverEmail;
    /**
     * receiver name
     */
    private String receiverName;
    /**
     * receiver phone
     */
    private String receiverPhone;
    /**
     * receiver post code
     */
    private String receiverPostcode;
    /**
     * province/metropolis
     */
    private String receiverProvince;
    /**
     * city
     */
    private String receiverCity;
    /**
     * region
     */
    private String receiverRegion;
    /**
     * receiver detail address
     */
    private String receiverAddress;
    /**
     * order note
     */
    private String note;
    /**
     * Confirmation of receipt status [0-> Not confirmed; 1-> Confirmed]
     */
    private Integer confirmStatus;
    /**
     * Deletion status [0-> Not deleted; 1-> Deleted]
     */
    private Integer deleteStatus;
    /**
     * Points used at the time of ordering
     */
    private Integer usedRewardPoint;
    /**
     * Payment date
     */
    private Date paymentDate;
    /**
     * Shipping date
     */
    private Date shippingDate;
    /**
     * Confirmation of receipt date
     */
    private Date receiveDate;
    /**
     * Comment date
     */
    private Date commentDate;
    /**
     * edte date
     */
    private Date editDate;
}