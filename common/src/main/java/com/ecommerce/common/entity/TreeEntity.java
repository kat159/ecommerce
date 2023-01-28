package com.ecommerce.common.entity;

public abstract class TreeEntity<InheritorT> {
    /**
     * 获取父节点ID
     */
    public abstract Long getParentId();

    /**
     * 获取节点ID
     */
    public abstract Long getId();

    /**
     * add a child into the children list
     */
    public abstract void addChild(InheritorT child);
}
