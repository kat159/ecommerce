package com.ecommerce.product.dto;

import com.ecommerce.common.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "sku images")
public class SkuImageDto extends BaseDto<SkuImageDto>
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

    @ApiModelProperty(value = "temporarily id")
    private String uid;
}