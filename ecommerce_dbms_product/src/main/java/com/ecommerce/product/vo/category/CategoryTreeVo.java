package com.ecommerce.product.vo;

import com.ecommerce.common.vo.TreeVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
@ApiModel(value = "product category, up to three-level categorization")
public class CategoryTreeVo extends TreeVo<CategoryTreeVo> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Long parentId;
    private Integer level;
    private Integer sort;
    private String icon;
    @ApiModelProperty(value = "Subcategories")
    private List<CategoryTreeVo> children;
    @Override
    public List<CategoryTreeVo> getChildren() {
        return children;
    }
    @Override
    public void setChildren(List<CategoryTreeVo> children) {
        this.children = children;
    }
}