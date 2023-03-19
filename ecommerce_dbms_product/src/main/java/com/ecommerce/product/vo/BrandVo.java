package com.ecommerce.product.vo;

import com.ecommerce.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
@ApiModel(value = "brand")
public class BrandVo extends BaseVo<BrandVo>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String logo;
    private String description;
    private Integer sort;
    private List<String> categoryNames;
    private List<ProductVo> products;


}