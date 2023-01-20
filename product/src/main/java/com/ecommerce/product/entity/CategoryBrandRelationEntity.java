package com.ecommerce.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 品牌分类关联
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@Data
@TableName("pms_category_brand_relation")
public class CategoryBrandRelationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

			/**
		 * 
		 */
				@TableId
			private Long id;
			/**
		 * 品牌id
		 */
			private Long brandId;
			/**
		 * 分类id
		 */
			private Long catelogId;
			/**
		 * 
		 */
			private String brandName;
			/**
		 * 
		 */
			private String catelogName;
	}