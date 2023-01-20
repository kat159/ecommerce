package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 属性分组
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@Data
@TableName("pms_attr_group")
public class AttrGroupEntity implements Serializable {
	private static final long serialVersionUID = 1L;

			/**
		 * 分组id
		 */
				@TableId
			private Long attrGroupId;
			/**
		 * 组名
		 */
			private String attrGroupName;
			/**
		 * 排序
		 */
			private Integer sort;
			/**
		 * 描述
		 */
			private String descript;
			/**
		 * 组图标
		 */
			private String icon;
			/**
		 * 所属分类id
		 */
			private Long catelogId;
	}