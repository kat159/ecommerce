package com.ecommerce.product.vo;

import com.ecommerce.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@ApiModel(value = "product information")
public class ProductVo extends BaseVo<ProductVo>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long categoryId;
    private Long brandId;
    @ApiModelProperty(value = "product name")
    private String name;
    @ApiModelProperty(value = "product description")
    private String description;
    @ApiModelProperty(value = "publish status [0 - not published, 1 - published]")
    private Integer publishStatus;
    private String brandName;
    private String categoryName;
    private List<ProductImageVo> images;
    private List<AttributeGroupVo> attributeGroups;
    private List<ProductAttrbuteValueVo> productAttributeValues;
    private List<SkuImageVo> skuImages;
    private List<SkuVo> skus;

}