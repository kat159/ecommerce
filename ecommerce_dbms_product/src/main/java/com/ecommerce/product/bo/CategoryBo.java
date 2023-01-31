package com.ecommerce.product.bo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.ecommerce.common.bo.TreeBo;
import lombok.Data;

import java.util.List;

@Data
public class CategoryBo extends TreeBo<CategoryBo> {
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
    private List<CategoryBo> children;

    @Override
    public Long getParentId() {
        return parentId;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void addChild(CategoryBo child) {
        children.add(child);
    }

    @Override
    public List<CategoryBo> getChildren() {
        return children;
    }

    @Override
    public void setChildren(List<CategoryBo> children) {
        this.children = children;
    }
}
