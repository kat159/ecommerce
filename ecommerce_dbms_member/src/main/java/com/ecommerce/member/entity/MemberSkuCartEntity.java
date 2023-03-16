package com.ecommerce.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ecommerce.common.entity.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName("member_sku_cart")
public class MemberSkuCartEntity extends BaseEntity<MemberSkuCartEntity> {

    /**
     * 
     */
		@TableId
		private Long id;
    /**
     * 
     */
		private Long memberId;
    /**
     * 
     */
		private Long skuId;
    /**
     * 
     */
		private Long quantity;
    /**
     * 
     */
		private Date createdAt;
    /**
     * 
     */
		private Date updatedAt;
}