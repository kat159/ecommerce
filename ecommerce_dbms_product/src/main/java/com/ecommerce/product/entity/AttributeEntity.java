package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ecommerce.common.entity.BaseEntity;
import lombok.Data;

@Data
@TableName("attribute")
public class AttributeEntity extends BaseEntity<AttributeEntity> {

    /**
     * Attribute ID
     */
    @TableId
    private Long id;
    /**
     *
     */
    private Long attributeGroupId;
    /**
     * attribute name
     */
    private String name;
    /**
     * attribute icon
     */
    private String icon;
    /**
     * [0-no, 1-yes]
     */
    private Integer searchStatus;
    /**
     * [0-single value, 1-multiple values can be selected]
     */
    private Integer selective;
    /**
     * list of selectable values (separated by contant.separator)
     */
    private String selectableValueList;
    /**
     * attribute type [0-sale attribute, 1-basic attribute, 2-both sale and basic attribute]
     */
    private Integer type;
    /**
     * status [0 - disabled, 1 - enabled]
     */
    private Long status;
    /**
     * [display on introduction or not; 0-no 1-yes], can still be adjusted in sku
     */
    private Integer display;
}