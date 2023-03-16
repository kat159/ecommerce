package com.ecommerce.member.vo;

import com.ecommerce.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



@Data
@ApiModel(value = "sku view record")
public class MemberSkuViewRecordVo extends BaseVo<MemberSkuViewRecordVo>
        implements Serializable {
    private static final long serialVersionUID = 1L;

            
        private Long id;
            
        private Long memberId;
            
        private Long skuId;
            
        private Date viewDate;
    
}