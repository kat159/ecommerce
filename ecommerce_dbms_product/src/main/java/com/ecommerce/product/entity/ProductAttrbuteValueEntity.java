package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("product_attrbute_value")
public class ProductAttrbuteValueEntity {

    /**
     * id
     */
		@TableId
		private Long id;
    /**
     * product id
     */
		private Long productId;
    /**
     * attribute id
     */
		private Long attributeId;
    /**
     * attribute name
     */
		private String attributeName;
    /**
     * attribute value
     */
		private String attributeValue;
    /**
     * sort order
     */
		private Integer attributeSort;
    /**
     * [whether to display on introduction; 0-no 1-yes]
     */
		private Integer display;
}