package com.ecommerce.product.vo;

import com.ecommerce.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "sku images")
public class SkuImageVo extends BaseVo<SkuImageVo>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "image url")
    private String img;
    @ApiModelProperty(value = "sort order")
    private Integer sort;
    @ApiModelProperty(value = "default image [0 - not default, 1 - default]")
    private Integer isDefault;

}