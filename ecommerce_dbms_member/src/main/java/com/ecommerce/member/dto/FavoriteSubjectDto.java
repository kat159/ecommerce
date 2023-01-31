package com.ecommerce.member.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "member favprote subject")
public class FavoriteSubjectDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "subject_id")
	private Long subjectId;

	@ApiModelProperty(value = "subject_name")
	private String subjectName;

	@ApiModelProperty(value = "subject_img")
	private String subjectImg;

	@ApiModelProperty(value = "subject url")
	private String subjectUrl;


}