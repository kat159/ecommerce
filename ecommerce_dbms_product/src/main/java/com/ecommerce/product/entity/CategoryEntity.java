package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.ecommerce.common.entity.BaseEntity;
import lombok.Data;

@Data
@TableName("category")
public class CategoryEntity extends BaseEntity<CategoryEntity> {

    @TableId
    private Long id;
    private String name;
    private Long parentId;
    private Integer level;
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer nonDeleted;
    private Integer sort;
    private String icon;
}