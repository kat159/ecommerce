package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("category")
public class CategoryEntity {

    /**
     * category id
     */
    @TableId
    private Long id;
    /**
     * category name
     */
    private String name;
    /**
     * parent category id
     */
    private Long parentId;
    /**
     * level
     */
    private Integer level;
    /**
     * for soft delete[0-deleted; 1-non-deleted]
     */
    private Integer nonDeleted;
    /**
     * sort order
     */
    private Integer sort;
    /**
     * icon address
     */
    private String icon;
    /**
     * unit of measurement
     */
    private String productUnit;
    /**
     * number of products
     */
    private Integer productCount;
}