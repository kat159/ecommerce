package com.ecommerce.member.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
@ApiModel(value = "member level info")
public class MemberLevelDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "level name")
	private String name;

	@ApiModelProperty(value = "membership_point required for the level")
	private Integer thresholdPoint;

	@ApiModelProperty(value = "whether it is default level[0->no; 1->yes]")
	private Integer defaultStatus;

	@ApiModelProperty(value = "amount threshold for this level")
	private BigDecimal freeFreightThreshold;

	@ApiModelProperty(value = "membership point obtained for each comment")
	private Integer pointFromComment;

	@ApiModelProperty(value = "whether has free shipping privilege")
	private Integer priviledgeFreeFreight;

	@ApiModelProperty(value = "whether has member price privilege")
	private Integer priviledgeMemberPrice;

	@ApiModelProperty(value = "whether has birthday privilege")
	private Integer priviledgeBirthday;

	@ApiModelProperty(value = "remarks")
	private String remark;


}