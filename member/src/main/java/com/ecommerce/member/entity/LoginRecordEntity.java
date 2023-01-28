package com.ecommerce.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("login_record")
public class LoginRecordEntity {

    /**
     * id
     */
		@TableId
		private Long id;
    /**
     * member_id
     */
		private Long memberId;
    /**
     * login date
     */
		private Date date;
    /**
     * ip
     */
		private String ip;
    /**
     * city
     */
		private String city;
    /**
     * [1-computer, 2-phone]
     */
		private Integer device;
    /**
     * login_type [1-website, 2-app]
     */
		private Integer app;
}