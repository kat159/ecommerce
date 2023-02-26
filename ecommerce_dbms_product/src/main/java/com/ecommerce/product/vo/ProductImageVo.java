package com.ecommerce.product.vo;

import com.ecommerce.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "product images")
public class ProductImageVo extends BaseVo<ProductImageVo>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long productId;
    @ApiModelProperty(value = "image url")
    private String url;
    @ApiModelProperty(value = "sort order")
    private Integer sort;
    @ApiModelProperty(value = "whether it is default image")
    private Integer isDefault;

}