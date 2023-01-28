package com.ecommerce.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("membership_point")
public class MembershipPointEntity {

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
     * Growth point source [0-shopping, 1-admin modification]
     */
		private Integer source;
}