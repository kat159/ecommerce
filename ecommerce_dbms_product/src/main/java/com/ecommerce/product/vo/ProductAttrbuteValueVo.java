package com.ecommerce.product.vo;

import com.ecommerce.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
@ApiModel(value = "product attribute value, many to one product")
public class ProductAttrbuteValueVo extends BaseVo<ProductAttrbuteValueVo>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long productId;
    private Long attributeId;
    @ApiModelProperty(value = "attribute value list， separated by Constant.separator")
    private String attributeValue;
    @ApiModelProperty(value = "attribute value list, split ")
    private String[] attributeValueList;
    @ApiModelProperty(value = "sort order")
    private Integer attributeSort;
    @ApiModelProperty(value = "[whether to display on introduction; 0-no 1-yes]")
    private Integer display;
    /**
     * additional field from attribute table
     */
    private String attributeName;
    /**
     * additional field from attribute table
     */
    private Integer attributeType;
}