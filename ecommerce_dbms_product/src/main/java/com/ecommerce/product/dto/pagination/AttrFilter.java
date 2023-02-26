package com.ecommerce.product.dto.pagination;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AttrFilter {
    Long id;
    List<String> values;
    public AttrFilter() {

    }
    public AttrFilter(Long id, String value) {
        this.id = id;
        this.values = List.of(value);
    }
}
