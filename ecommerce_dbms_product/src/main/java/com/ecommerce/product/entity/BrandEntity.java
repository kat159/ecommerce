package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.ecommerce.common.entity.BaseEntity;
import lombok.Data;

@Data
@TableName("brand")
public class BrandEntity extends BaseEntity<BrandEntity> {

    /**
     * brand ID
     */
    @TableId
    private Long id;
    /**
     * brand name
     */
    private String name;
    /**
     * brand logo address
     */
    private String logo;
    /**
     * introduction
     */
    private String description;
    /**
     * for soft delete[0-deleted; 1-non-deleted]
     */
    @TableLogic
    private Integer nonDeleted;
    /**
     * search first letter
     */
    private String firstLetter;
    /**
     * sort order
     */
    private Integer sort;
}