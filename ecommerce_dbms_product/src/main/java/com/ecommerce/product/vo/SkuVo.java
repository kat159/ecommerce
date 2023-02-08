package com.ecommerce.product.vo;

import com.ecommerce.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
@ApiModel(value = "sku")
public class SkuVo extends BaseVo<SkuVo>
        implements Serializable {
    private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "sku id")
        private Long id;
            @ApiModelProperty(value = "product id")
        private Long productId;
            @ApiModelProperty(value = "category id")
        private Long categoryId;
            @ApiModelProperty(value = "brand id")
        private Long brandId;
            @ApiModelProperty(value = "sku name")
        private String name;
            @ApiModelProperty(value = "sku description")
        private String description;
            @ApiModelProperty(value = "default image")
        private String defaultImg;
            @ApiModelProperty(value = "title")
        private String title;
            @ApiModelProperty(value = "subtitle")
        private String subtitle;
            @ApiModelProperty(value = "price")
        private BigDecimal price;
            @ApiModelProperty(value = "sales count")
        private Long saleCount;
    
}