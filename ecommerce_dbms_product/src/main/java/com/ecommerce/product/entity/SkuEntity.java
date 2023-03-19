package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ecommerce.common.entity.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("sku")
public class SkuEntity extends BaseEntity<SkuEntity> {

    @TableId
    private Long id;
    private Long productId;
    private String name;
    private String description;
    private String defaultImg;
    private String title;
    private String subtitle;
    private BigDecimal price;
    private Long saleCount;
    private BigDecimal primeDiscount;
    private BigDecimal giftCardBonus;
    private Long stock;
    private BigDecimal finalPrice;
    private BigDecimal rating;
    private Integer status;
    private Long ratingCount;

}