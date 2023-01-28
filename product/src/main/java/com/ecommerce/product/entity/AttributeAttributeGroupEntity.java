package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("attribute_attribute_group")
public class AttributeAttributeGroupEntity {

    /**
     * id
     */
		@TableId
		private Long id;
    /**
     * attribute ID
     */
		private Long attrId;
    /**
     * attribute group ID
     */
		private Long attrGroupId;
    /**
     * sort order within group
     */
		private Integer attrSort;
}