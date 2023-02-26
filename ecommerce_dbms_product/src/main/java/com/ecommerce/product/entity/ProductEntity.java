package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ecommerce.common.entity.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName("product")
public class ProductEntity extends BaseEntity<ProductEntity> {

    /**
     * product id
     */
    @TableId
    private Long id;
    /**
     * category id
     */
    private Long categoryId;
    /**
     * brand id
     */
    private Long brandId;
    /**
     * product name
     */
    private String name;
    /**
     * product description
     */
    private String description;
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