package com.ecommerce.product.vo.category;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class AttrGroupWithAttrVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private Integer sort;

    private List<Attribute> saleAttrs = new ArrayList<>();

    private List<Attribute> specAttrs = new ArrayList<>();

    private List<Attribute> commonAttrs = new ArrayList<>();

    public void addSaleAttr(Long id, String name, String[] values) {
        saleAttrs.add(new Attribute(id, name, values));
    }
    public void addSpecAttr(Long id, String name, String[] values) {
        specAttrs.add(new Attribute(id, name, values));
    }
    public void addCommonAttr(Long id, String name, String[] values) {
        commonAttrs.add(new Attribute(id, name, values));
    }

}
@Data
class Attribute {
    private Long id;
    private String name;
    private String[] values;

    public Attribute() {
    }
    public Attribute(Long id, String name, String[] values) {
        this.id = id;
        this.name = name;
        this.values = values;
    }
}

