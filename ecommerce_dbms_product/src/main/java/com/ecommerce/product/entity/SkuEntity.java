package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("sku")
public class SkuEntity {

    /**
     * sku id
     */
		@TableId
		private Long id;
    /**
     * product id
     */
		private Long productId;
    /**
     * sku name
     */
		private String name;
    /**
     * sku description
     */
		private String description;
    /**
     * category id
     */
		private Long categoryId;
    /**
     * brand id
     */
		private Long brandId;
    /**
     * default image
     */
		private String defaultImg;
    /**
     * title
     */
		private String title;
    /**
     * subtitle
     */
		private String subtitle;
    /**
     * price
     */
		private BigDecimal price;
    /**
     * sales count
     */
		private Long saleCount;
}