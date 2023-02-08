package com.ecommerce.common.vo;

import java.util.List;

public abstract class TreeVo<InheritorT> extends BaseVo<InheritorT> {
    /**
     * get children list
     */
    public abstract List<InheritorT> getChildren();

    /**
     * set children list
     */
    public abstract void setChildren(List<InheritorT> children);
}
