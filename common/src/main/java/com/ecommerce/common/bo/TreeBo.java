package com.ecommerce.common.bo;

import java.util.List;

public abstract class TreeBo<InheritorT> {
    public abstract Long getParentId();
    public abstract Long getId();
    /**
     * add a child into the children list
     */
    public abstract void addChild(InheritorT child);

    /**
     * get children list
     */
    public abstract List<InheritorT> getChildren();

    /**
     * set children list
     */
    public abstract void setChildren(List<InheritorT> children);

}
