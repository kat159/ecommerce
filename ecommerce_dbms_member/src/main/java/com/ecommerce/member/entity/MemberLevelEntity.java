package com.ecommerce.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("member_level")
public class MemberLevelEntity {

    /**
     * id
     */
		@TableId
		private Long id;
    /**
     * level name
     */
		private String name;
    /**
     * membership_point required for the level
     */
		private Integer thresholdPoint;
    /**
     * whether it is default level[0->no; 1->yes]
     */
		private Integer defaultStatus;
    /**
     * amount threshold for this level
     */
		private BigDecimal freeFreightThreshold;
    /**
     * membership point obtained for each comment
     */
		private Integer pointFromComment;
    /**
     * whether has free shipping privilege
     */
		private Integer priviledgeFreeFreight;
    /**
     * whether has member price privilege
     */
		private Integer priviledgeMemberPrice;
    /**
     * whether has birthday privilege
     */
		private Integer priviledgeBirthday;
    /**
     * remarks
     */
		private String remark;
}