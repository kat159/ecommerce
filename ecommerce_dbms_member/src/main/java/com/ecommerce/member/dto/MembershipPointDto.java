package com.ecommerce.member.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



@Data
@ApiModel(value = "membership history, many to one member")
public class MembershipPointDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "ID")
	private Long id;

	@ApiModelProperty(value = "Member ID")
	private Long memberId;

	@ApiModelProperty(value = "Date updated")
	private Date updatedDate;

	@ApiModelProperty(value = "Changed value")
	private Integer changedValue;

	@ApiModelProperty(value = "Note")
	private String note;

	@ApiModelProperty(value = "Growth point source [0-shopping, 1-admin modification]")
	private Integer source;


}