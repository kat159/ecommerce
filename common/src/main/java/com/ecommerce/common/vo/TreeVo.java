package com.ecommerce.common.vo;

import java.util.List;

public abstract class TreeVo<InheritorT> extends BaseVo<InheritorT> {

    public abstract List<InheritorT> getChildren();

    public abstract void setChildren(List<InheritorT> children);
}
