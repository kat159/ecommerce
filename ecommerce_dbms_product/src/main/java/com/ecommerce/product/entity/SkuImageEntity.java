package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ecommerce.common.entity.BaseEntity;
import lombok.Data;

@Data
@TableName("sku_image")
public class SkuImageEntity extends BaseEntity<SkuImageEntity> {

    /**
     * id
     */
		@TableId
		private Long id;
    /**
     * image url
     */
		private String img;
    /**
     * sort order
     */
		private Integer sort;
    /**
     * default image [0 - not default, 1 - default]
     */
		private Integer isDefault;
}