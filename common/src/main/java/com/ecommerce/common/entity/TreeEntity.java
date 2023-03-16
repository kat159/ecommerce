package com.ecommerce.common.entity;

public abstract class TreeEntity<InheritorT> {

    public abstract Long getParentId();

    public abstract Long getId();

    /**
     * add a child into the children list
     */
    public abstract void addChild(InheritorT child);
}
