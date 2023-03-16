package com.ecommerce.member.dto;

import com.ecommerce.common.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;



@Data
@ApiModel(value = "member information")
public class MemberDto extends BaseDto<MemberDto>
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
	// @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birth;
	private Integer referSource;
	private Integer status;
	// @DateTimeFormat(pattern = "yyyy-MM-dd:HH:mm:ss")
	private Date registrationDate;
	private Long countryId;
	private Long stateId;
	private Long cityId;
}