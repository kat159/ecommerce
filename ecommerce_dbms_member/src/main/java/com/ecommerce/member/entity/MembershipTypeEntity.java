package com.ecommerce.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ecommerce.common.entity.BaseEntity;
import lombok.Data;

@Data
@TableName("membership_type")
public class MembershipTypeEntity extends BaseEntity<MembershipTypeEntity> {

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
     * 
     */
		private Integer activatePrice;
}