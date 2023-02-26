package com.ecommerce.product.vo;

import com.ecommerce.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "join table")
public class CategoryBrandVo extends BaseVo<CategoryBrandVo>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long brandId;
    private Long categoryId;
    private String brandName;
    private String categoryName;

}