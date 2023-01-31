package com.ecommerce.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("homepage_subject_product")
public class HomepageSubjectProductEntity {

    /**
     * id
     */
		@TableId
		private Long id;
    /**
     * Subject Name
     */
		private String name;
    /**
     * Subject ID
     */
		private Long subjectId;
    /**
     * Product ID
     */
		private Long productId;
    /**
     * Sort
     */
		private Integer sort;
}