package com.ecommerce.member.vo;

import com.ecommerce.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@ApiModel(value = "member favorite_product")
public class FavoriteProductVo extends BaseVo<FavoriteProductVo>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long memberId;
    private Long productId;
    private String productName;
    private String productImg;
    @ApiModelProperty(value = "Date added to favorites")
    private Date addDate;

}