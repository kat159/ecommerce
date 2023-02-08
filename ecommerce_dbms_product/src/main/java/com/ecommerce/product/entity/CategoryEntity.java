package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.ecommerce.common.entity.BaseEntity;
import lombok.Data;

@Data
@TableName("category")
public class CategoryEntity extends BaseEntity<CategoryEntity> {

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
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer nonDeleted;
    /**
     * sort order
     */
    private Integer sort;
    /**
     * icon address
     */
    private String icon;
}