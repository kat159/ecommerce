package com.ecommerce.product.dto.aggregate;

import lombok.Data;

import java.util.List;

@Data
public class MultiValueAttribute {
    Long id;
    List<String> values;
}
