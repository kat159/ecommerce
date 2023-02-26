package com.ecommerce.product.dto.aggregate;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProductPublishDto
        implements Serializable {
    private static final long serialVersionUID = 1L;
    Long brandId;
    Long categoryId;
    String name;
    String description;
    List<Image> productImageList; // upload image in frontend
    List<MultiValueAttribute> saleAttrs;
    List<MultiValueAttribute> specAttrs;
    List<Image> skuImageList; // upload image in frontend
    List<Sku> skuList;
    Integer publishStatus;
}


