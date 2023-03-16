package com.ecommerce.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ecommerce.common.entity.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName("member")
public class MemberEntity extends BaseEntity<MemberEntity> {
    @TableId
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