package com.ecommerce.member.vo;

import com.ecommerce.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@ApiModel(value = "member information")
public class MemberVo extends BaseVo<MemberVo>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long membershipTypeId;
    private String username;
    private String password;
    private String nickname;
    private String tele;
    private String email;
    private String avatar;
    private Integer gender;
    private Date birth;
    private Integer status;
    private Date registrationDate;
    private Long countryId;
    private Long stateId;
    private Long cityId;
}