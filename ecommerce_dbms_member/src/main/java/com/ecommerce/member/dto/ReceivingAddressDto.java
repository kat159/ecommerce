package com.ecommerce.member.dto;

import com.ecommerce.common.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "Member Receive Address")
public class ReceivingAddressDto extends BaseDto<ReceivingAddressDto>
		implements Serializable {
    private static final long serialVersionUID = 1L;

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