package com.ecommerce.product.vo.aggregate;

import com.ecommerce.product.vo.ProductImageVo;
import com.ecommerce.product.vo.SkuVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProductSearchVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private SkuVo sku;
}
