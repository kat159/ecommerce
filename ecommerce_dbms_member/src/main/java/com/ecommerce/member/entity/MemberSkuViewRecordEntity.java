package com.ecommerce.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ecommerce.common.entity.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName("member_sku_view_record")
public class MemberSkuViewRecordEntity extends BaseEntity<MemberSkuViewRecordEntity> {

		@TableId
		private Long id;

		private Long memberId;

		private Long skuId;

		private Date viewDate;
}