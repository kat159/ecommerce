package com.ecommerce.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("favorite_subject")
public class FavoriteSubjectEntity {

    /**
     * id
     */
		@TableId
		private Long id;
    /**
     * subject_id
     */
		private Long subjectId;
    /**
     * subject_name
     */
		private String subjectName;
    /**
     * subject_img
     */
		private String subjectImg;
    /**
     * subject url
     */
		private String subjectUrl;
}