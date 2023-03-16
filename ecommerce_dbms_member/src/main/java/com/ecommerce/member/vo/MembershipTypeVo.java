package com.ecommerce.member.vo;

import com.ecommerce.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "like 'prime', 'prime pro'")
public class MembershipTypeVo extends BaseVo<MembershipTypeVo>
        implements Serializable {
    private static final long serialVersionUID = 1L;

            
        private Long id;
            
        private String name;
            
        private Integer activatePrice;
    
}