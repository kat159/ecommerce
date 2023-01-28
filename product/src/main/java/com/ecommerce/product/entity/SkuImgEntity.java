package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sku_img")
public class SkuImgEntity {

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