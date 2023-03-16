package com.ecommerce.member.dto;

import com.ecommerce.common.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "like 'prime', 'prime pro'")
public class MembershipTypeDto extends BaseDto<MembershipTypeDto>
		implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "level name")
	private String name;

	@ApiModelProperty(value = "")
	private Integer activatePrice;


}