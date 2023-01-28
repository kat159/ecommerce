package com.ecommerce.member.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



@Data
@ApiModel(value = "member information")
public class MemberDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "ID")
	private Long id;

	@ApiModelProperty(value = "Member level ID")
	private Long levelId;

	@ApiModelProperty(value = "Username")
	private String username;

	@ApiModelProperty(value = "Password")
	private String password;

	@ApiModelProperty(value = "Nickname")
	private String nickname;

	@ApiModelProperty(value = "tele number")
	private String tele;

	@ApiModelProperty(value = "Email")
	private String email;

	@ApiModelProperty(value = "Avatar")
	private String avatar;

	@ApiModelProperty(value = "Gender")
	private Integer gender;

	@ApiModelProperty(value = "Birthday")
	private Date birth;

	@ApiModelProperty(value = "City")
	private String city;

	@ApiModelProperty(value = "Occupation")
	private String job;

	@ApiModelProperty(value = "bio")
	private String bio;

	@ApiModelProperty(value = "How the user know us")
	private Integer referSource;

	@ApiModelProperty(value = "membership_point")
	private Integer membershipPoint;

	@ApiModelProperty(value = "reward_point")
	private Integer rewardPoint;

	@ApiModelProperty(value = "Status")
	private Integer status;

	@ApiModelProperty(value = "Registration date")
	private Date registrationDate;


}