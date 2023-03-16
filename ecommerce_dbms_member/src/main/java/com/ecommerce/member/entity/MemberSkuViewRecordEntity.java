package com.ecommerce.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ecommerce.common.entity.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName("member_sku_view_record")
public class MemberSkuViewRecordEntity extends BaseEntity<MemberSkuViewRecordEntity> {

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
     * Product ID
     */
		private Long skuId;
    /**
     * View date
     */
		private Date viewDate;
}