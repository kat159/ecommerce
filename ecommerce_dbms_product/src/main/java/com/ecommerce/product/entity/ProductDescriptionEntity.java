package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ecommerce.common.entity.BaseEntity;
import lombok.Data;

@Data
@TableName("product_description")
public class ProductDescriptionEntity extends BaseEntity<ProductDescriptionEntity> {

    /**
     * product id
     */
    @TableId
    private Long productId;
    /**
     * product introduction
     */
    private String description;


    @Override
    public Long getId() {
        return productId;
    }
}