package com.ecommerce.product.vo;

import com.ecommerce.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "product description, partitioned data, one to one product with primary key mapping to product_id")
public class ProductDescriptionVo extends BaseVo<ProductDescriptionVo>
        implements Serializable {
    private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "product id")
        private Long productId;
            @ApiModelProperty(value = "product introduction")
        private String description;
    
}