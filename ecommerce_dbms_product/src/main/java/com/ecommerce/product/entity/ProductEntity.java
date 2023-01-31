package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("product")
public class ProductEntity {

    /**
     * product id
     */
		@TableId
		private Long id;
    /**
     * product name
     */
		private String name;
    /**
     * product description
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
     * 
     */
		private BigDecimal weight;
    /**
     * publish status [0 - not published, 1 - published]
     */
		private Integer publishStatus;
    /**
     * 
     */
		private Date createTime;
    /**
     * 
     */
		private Date updateTime;
}