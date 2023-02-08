package com.ecommerce.product.bo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.ecommerce.common.bo.TreeBo;
import com.ecommerce.common.validation.group.Save;
import com.ecommerce.common.validation.group.Update;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class CategoryTreeBo extends TreeBo<CategoryTreeBo> {
    /**
     * category id
     */
    @TableId
    private Long id;
    /**
     * category name
     */
    @NotBlank(message = "category name is required", groups = {Save.class, Update.class})
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
    /**
     * children
     */
    private List<CategoryTreeBo> children;

    @Override
    public Long getParentId() {
        return parentId;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void addChild(CategoryTreeBo child) {
        children.add(child);
    }

    @Override
    public List<CategoryTreeBo> getChildren() {
        return children;
    }

    @Override
    public void setChildren(List<CategoryTreeBo> children) {
        this.children = children;
    }
}
