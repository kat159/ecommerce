package com.ecommerce.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ecommerce.common.entity.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName("favorite_product")
public class FavoriteProductEntity extends BaseEntity<FavoriteProductEntity> {


    @TableId
    private Long id;
    private Long memberId;
    private Long productId;
    private String productName;
    private String productImg;
    private Date addDate;
}