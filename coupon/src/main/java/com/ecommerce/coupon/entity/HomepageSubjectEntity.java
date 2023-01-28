package com.ecommerce.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("homepage_subject")
public class HomepageSubjectEntity {

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
     * Subject Title
     */
		private String title;
    /**
     * Subject Subtitle
     */
		private String subTitle;
    /**
     * Display Status
     */
		private Integer displayStatus;
    /**
     * Detail Link
     */
		private String link;
    /**
     * Sort
     */
		private Integer sort;
    /**
     * Subject Image URL
     */
		private String img;
}