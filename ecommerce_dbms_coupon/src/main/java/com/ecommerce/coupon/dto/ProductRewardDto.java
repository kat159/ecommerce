package com.ecommerce.coupon.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
@ApiModel(value = "Reward of reward points and membership point for buying the product ")
public class ProductRewardDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "")
    private Long productId;

    @ApiModelProperty(value = "membership point")
    private BigDecimal membershipPoint;

    @ApiModelProperty(value = "reward point")
    private BigDecimal rewardPoint;

    @ApiModelProperty(value = "Reward effectiveness [1111 (four states from right to left); 0 - no promotion, membership_point gained or not; 1 - no promotion, reward_point gained or not; 2 - promotion, membership_point gained or not; 3 - promotion, reward_point gained or not [state 0: not gained, 1: gained]]")
    private Integer effectiveness;


}