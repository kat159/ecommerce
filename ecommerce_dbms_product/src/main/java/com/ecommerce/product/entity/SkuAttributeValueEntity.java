package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ecommerce.common.entity.BaseEntity;
import lombok.Data;

@Data
@TableName("sku_attribute_value")
public class SkuAttributeValueEntity extends BaseEntity<SkuAttributeValueEntity> {

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
		private Long attributeId;
    /**
     * 
     */
		private String attributeName;
    /**
     * 
     */
		private String attributeValue;
    /**
     * assume List[img1, img2, img3], sort=index
     */
		private Integer sort;
}