package com.ecommerce.product.vo;

import com.ecommerce.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "join table")
public class ReviewReplyVo extends BaseVo<ReviewReplyVo>
        implements Serializable {
    private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "id")
        private Long id;
            @ApiModelProperty(value = "comment id")
        private Long reviewId;
            @ApiModelProperty(value = "reply id")
        private Long replyId;
    
}