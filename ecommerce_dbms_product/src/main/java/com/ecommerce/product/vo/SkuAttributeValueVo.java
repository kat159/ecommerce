package com.ecommerce.product.vo;

import com.ecommerce.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "")
public class SkuAttributeValueVo extends BaseVo<SkuAttributeValueVo>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long skuId;
    private Long attributeId;
    private String attributeName;
    private String attributeValue;
    private Integer sort;

}