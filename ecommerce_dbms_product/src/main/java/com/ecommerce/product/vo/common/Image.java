package com.ecommerce.product.vo.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Image implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String url;
}
