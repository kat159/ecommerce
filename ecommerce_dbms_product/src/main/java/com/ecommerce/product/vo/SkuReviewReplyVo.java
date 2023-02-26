package com.ecommerce.product.vo;

import com.ecommerce.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "")
public class SkuReviewReplyVo extends BaseVo<SkuReviewReplyVo>
        implements Serializable {
    private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "id")
        private Long id;
            @ApiModelProperty(value = "review id")
        private Long skuReviewId;
            @ApiModelProperty(value = "reply id")
        private Long replyId;
    
}