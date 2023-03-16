package com.ecommerce.member.dto;

import com.ecommerce.common.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



@Data
@ApiModel(value = "")
public class MemberSkuCartDto extends BaseDto<MemberSkuCartDto>
		implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;
	private Long memberId;
	private Long skuId;
	private Long quantity;
	private Date createdAt;
	private Date updatedAt;
}