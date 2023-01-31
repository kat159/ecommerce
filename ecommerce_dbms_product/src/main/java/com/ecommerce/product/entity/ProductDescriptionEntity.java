package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("product_description")
public class ProductDescriptionEntity {

    /**
     * product id
     */
		@TableId
		private Long productId;
    /**
     * product introduction
     */
		private String description;
}