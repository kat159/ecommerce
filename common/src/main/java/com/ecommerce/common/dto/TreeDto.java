package com.ecommerce.common.dto;

import java.util.List;

public abstract class TreeDto<InheritorT> {
    /**
     * get children list
     */
    public abstract List<InheritorT> getChildren();

    /**
     * set children list
     */
    public abstract void setChildren(List<InheritorT> children);
}
