package com.ecommerce.member.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



@Data
@ApiModel(value = "member login record")
public class LoginRecordDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "member_id")
	private Long memberId;

	@ApiModelProperty(value = "login date")
	private Date date;

	@ApiModelProperty(value = "ip")
	private String ip;

	@ApiModelProperty(value = "city")
	private String city;

	@ApiModelProperty(value = "[1-computer, 2-phone]")
	private Integer device;

	@ApiModelProperty(value = "login_type [1-website, 2-app]")
	private Integer app;


}