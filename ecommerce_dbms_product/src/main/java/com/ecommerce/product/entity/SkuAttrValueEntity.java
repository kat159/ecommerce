package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ecommerce.common.entity.BaseEntity;
import lombok.Data;

@Data
@TableName("sku_attr_value")
public class SkuAttrValueEntity extends BaseEntity<SkuAttrValueEntity> {

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
     * assume List[img1, img2, img3], display_order=index
     */
		private Integer displayOrder;
}