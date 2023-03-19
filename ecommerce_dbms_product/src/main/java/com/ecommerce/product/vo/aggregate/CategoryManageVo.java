package com.ecommerce.product.vo.aggregate;


import com.ecommerce.product.vo.AttributeGroupVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CategoryManageVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Long parentId;
    @ApiModelProperty(value = "category tree level")
    private Integer level;
    @ApiModelProperty(value = "icon address")
    private String icon;
    private Integer sort;
    private List<CategoryManageVo> children;
    private List<AttributeGroupVo> attributeGroups;
}
