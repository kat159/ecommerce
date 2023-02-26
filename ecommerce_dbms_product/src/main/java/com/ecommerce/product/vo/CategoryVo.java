package com.ecommerce.product.vo;

import com.ecommerce.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "product category, up to three-level categorization")
public class CategoryVo extends BaseVo<CategoryVo>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Long parentId;
    @ApiModelProperty(value = "category tree level")
    private Integer level;
    @ApiModelProperty(value = "for soft delete[0-deleted; 1-non-deleted]")
    private Integer nonDeleted;
    @ApiModelProperty(value = "sort order")
    private Integer sort;
    @ApiModelProperty(value = "icon address")
    private String icon;

}