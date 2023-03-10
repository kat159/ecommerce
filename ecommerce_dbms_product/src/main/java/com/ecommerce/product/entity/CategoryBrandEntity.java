package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ecommerce.common.entity.BaseEntity;
import lombok.Data;

@Data
@TableName("category_brand")
public class CategoryBrandEntity extends BaseEntity<CategoryBrandEntity> {

    /**
     * 
     */
		@TableId
		private Long id;
    /**
     * brand id
     */
		private Long brandId;
    /**
     * category id
     */
		private Long categoryId;
    /**
     * 
     */
		private String brandName;
    /**
     * 
     */
		private String categoryName;
}