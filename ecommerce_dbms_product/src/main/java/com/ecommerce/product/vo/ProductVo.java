package com.ecommerce.product.vo;

import com.ecommerce.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@ApiModel(value = "product information")
public class ProductVo extends BaseVo<ProductVo>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "product id")
    private Long id;
    @ApiModelProperty(value = "category id")
    private Long categoryId;
    @ApiModelProperty(value = "brand id")
    private Long brandId;
    @ApiModelProperty(value = "product name")
    private String name;
    @ApiModelProperty(value = "product description")
    private String description;
    @ApiModelProperty(value = "publish status [0 - not published, 1 - published]")
    private Integer publishStatus;
    @ApiModelProperty(value = "")
    private Date createTime;
    @ApiModelProperty(value = "")
    private Date updateTime;

}