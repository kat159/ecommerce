package com.ecommerce.member.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "Member Receive Address")
public class ReceivingAddressDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "ID")
	private Long id;

	@ApiModelProperty(value = "Member ID")
	private Long memberId;

	@ApiModelProperty(value = "Receiver Name")
	private String name;

	@ApiModelProperty(value = "Tele number")
	private String tele;

	@ApiModelProperty(value = "Postal Code")
	private String postcode;

	@ApiModelProperty(value = "Province/Metropolis")
	private String province;

	@ApiModelProperty(value = "City")
	private String city;

	@ApiModelProperty(value = "Region")
	private String region;

	@ApiModelProperty(value = "Detail address(street)")
	private String address;


}