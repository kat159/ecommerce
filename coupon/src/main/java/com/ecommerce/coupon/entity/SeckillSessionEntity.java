package com.ecommerce.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 秒杀活动场次
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@Data
@TableName("sms_seckill_session")
public class SeckillSessionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

			/**
		 * id
		 */
				@TableId
			private Long id;
			/**
		 * 场次名称
		 */
			private String name;
			/**
		 * 每日开始时间
		 */
			private Date startTime;
			/**
		 * 每日结束时间
		 */
			private Date endTime;
			/**
		 * 启用状态
		 */
			private Integer status;
			/**
		 * 创建时间
		 */
			private Date createTime;
	}