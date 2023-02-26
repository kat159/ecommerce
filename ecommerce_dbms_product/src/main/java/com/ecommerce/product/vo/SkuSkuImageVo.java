package com.ecommerce.product.vo;

import com.ecommerce.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "join table")
public class SkuSkuImageVo extends BaseVo<SkuSkuImageVo>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long skuId;
    private Long skuImageId;
    private Long id;
    private Integer sort;
    private String url;
}