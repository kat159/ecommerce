package com.ecommerce.product.dto.aggregate;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Sku {
    String name;
    String description;
    String title;
    String subtitle;
    BigDecimal price;
    List<SingleValueAttribute> saleAttrs;
    List<String> imageIdList; // uid of image
    Long saleCount;
    BigDecimal giftCardBonus;
    BigDecimal primeDiscount;
    Long stock;
    BigDecimal rating;
    Integer status;
}
