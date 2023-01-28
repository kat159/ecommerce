package com.ecommerce.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("reward_point")
public class RewardPointEntity {

    /**
     * ID
     */
		@TableId
		private Long id;
    /**
     * Member ID
     */
		private Long memberId;
    /**
     * Date updated
     */
		private Date updatedDate;
    /**
     * Changed value
     */
		private Integer changedValue;
    /**
     * Note
     */
		private String note;
    /**
     * Source [0->shopping; 1->admin modification; 2->activity]
     */
		private Integer source;
}