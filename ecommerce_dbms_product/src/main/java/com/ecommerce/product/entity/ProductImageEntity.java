package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ecommerce.common.entity.BaseEntity;
import lombok.Data;

@Data
@TableName("product_image")
public class ProductImageEntity extends BaseEntity<ProductImageEntity> {

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
		private String name;
    /**
     * image url
     */
		private String url;
    /**
     * assume List[img1, img2, img3], display_order=index
     */
		private Integer displayOrder;
    /**
     * whether it is default image
     */
		private Integer isDefault;
}