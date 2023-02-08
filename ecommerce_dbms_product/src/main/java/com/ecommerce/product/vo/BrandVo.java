package com.ecommerce.product.vo;

import com.ecommerce.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "brand")
public class BrandVo extends BaseVo<BrandVo>
        implements Serializable {
    private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "brand ID")
        private Long id;
            @ApiModelProperty(value = "brand name")
        private String name;
            @ApiModelProperty(value = "brand logo address")
        private String logo;
            @ApiModelProperty(value = "introduction")
        private String description;
            @ApiModelProperty(value = "for soft delete[0-deleted; 1-non-deleted]")
        private Integer nonDeleted;
            @ApiModelProperty(value = "search first letter")
        private String firstLetter;
            @ApiModelProperty(value = "sort order")
        private Integer sort;
    
}