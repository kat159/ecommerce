package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("attribute_group")
public class AttributeGroupEntity {

    /**
     * group ID
     */
		@TableId
		private Long id;
    /**
     * group name
     */
		private String name;
    /**
     * sort order
     */
		private Integer sort;
    /**
     * description
     */
		private String description;
    /**
     * group icon
     */
		private String icon;
    /**
     * category it belongs to
     */
		private Long categoryId;
}