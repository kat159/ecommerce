package com.ecommerce.common.entity;

import lombok.Data;

@Data
public abstract class BaseEntity<EntityT> {

    public abstract Long getId();
}
