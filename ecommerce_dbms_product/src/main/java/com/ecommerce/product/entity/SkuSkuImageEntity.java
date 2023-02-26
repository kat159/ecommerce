package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ecommerce.common.entity.BaseEntity;
import lombok.Data;

@Data
@TableName("sku_sku_image")
public class SkuSkuImageEntity extends BaseEntity<SkuSkuImageEntity> {

    /**
     * 
     */
		private Long skuId;
    /**
     * 
     */
		private Long skuImageId;
    /**
     * 
     */
		@TableId
		private Long id;
    /**
     * 
     */
		private Integer sort;
}