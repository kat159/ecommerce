package com.ecommerce.product.vo;

import com.ecommerce.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.ecommerce.product.vo.common.Image;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Data
@ApiModel(value = "sku")
public class SkuVo extends BaseVo<SkuVo>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long productId;
    private String name;
    private String description;
    private String defaultImg;
    private String title;
    private String subtitle;
    private BigDecimal price;
    private Long saleCount;
    private BigDecimal primeDiscount;
    private BigDecimal giftCardBonus;
    private Long stock;
    private BigDecimal rating;
    private List<SkuSkuImageVo> skuSkuImages;
    private List<SkuAttributeValueVo> saleAttrValues;
    private List<SkuReviewVo> reviews;
    private List<SkuImageVo> skuImages;
    private Integer status;
}