package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ecommerce.common.entity.BaseEntity;
import lombok.Data;

@Data
@TableName("product_description")
public class ProductDescriptionEntity extends BaseEntity<ProductDescriptionEntity> {

    /**
     * product id, One-to-one relationship with product table
     */
    @TableId
    private Long productId;
    /**
     * product introduction
     */
    private String description;

	public Long getId() {
		return productId;
	}
}