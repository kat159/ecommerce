package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sku_attr_value")
public class SkuAttrValueEntity {

    /**
     * id
     */
		@TableId
		private Long id;
    /**
     * sku id
     */
		private Long skuId;
    /**
     * attribute id
     */
		private Long attrId;
    /**
     * sale attribute name
     */
		private String attrName;
    /**
     * sale attribute value
     */
		private String attrValue;
    /**
     * sort order
     */
		private Integer attrSort;
}