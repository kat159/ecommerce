package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("product_images")
public class ProductImagesEntity {

    /**
     * id
     */
		@TableId
		private Long id;
    /**
     * product id
     */
		private Long productId;
    /**
     * image name
     */
		private String imgName;
    /**
     * image url
     */
		private String imgUrl;
    /**
     * sort order
     */
		private Integer imgSort;
    /**
     * whether it is default image
     */
		private Integer defaultImg;
}