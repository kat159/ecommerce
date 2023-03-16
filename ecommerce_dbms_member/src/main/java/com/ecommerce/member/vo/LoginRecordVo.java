package com.ecommerce.member.vo;

import com.ecommerce.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@ApiModel(value = "member login record")
public class LoginRecordVo extends BaseVo<LoginRecordVo>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long memberId;
    private Date date;
    private String ip;
    private String city;
    
    private Integer device;
    
    private Integer app;

}