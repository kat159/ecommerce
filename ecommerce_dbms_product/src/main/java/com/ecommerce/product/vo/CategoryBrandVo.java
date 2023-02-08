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

            @ApiModelProperty(value = "")
        private Long id;
            @ApiModelProperty(value = "brand id")
        private Long brandId;
            @ApiModelProperty(value = "category id")
        private Long categoryId;
            @ApiModelProperty(value = "")
        private String brandName;
            @ApiModelProperty(value = "")
        private String categoryName;
    
}