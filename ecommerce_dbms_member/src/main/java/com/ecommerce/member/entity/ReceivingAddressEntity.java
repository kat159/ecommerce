package com.ecommerce.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ecommerce.common.entity.BaseEntity;
import lombok.Data;

@Data
@TableName("receiving_address")
public class ReceivingAddressEntity extends BaseEntity<ReceivingAddressEntity> {

    @TableId
    private Long id;
    private Long memberId;
    private String name;
    private String tele;
    private String postcode;
    private String province;
    private String region;
    private String address;
	private Long priority;
    private Long countryId;
    private Long stateId;
    private Long cityId;
    private String country;
    private String state;
    private String city;
    private String countryCode;
    private String stateCode;
}