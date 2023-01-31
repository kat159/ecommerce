package com.ecommerce.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("member")
public class MemberEntity {

    /**
     * ID
     */
		@TableId
		private Long id;
    /**
     * Member level ID
     */
		private Long levelId;
    /**
     * Username
     */
		private String username;
    /**
     * Password
     */
		private String password;
    /**
     * Nickname
     */
		private String nickname;
    /**
     * tele number
     */
		private String tele;
    /**
     * Email
     */
		private String email;
    /**
     * Avatar
     */
		private String avatar;
    /**
     * Gender
     */
		private Integer gender;
    /**
     * Birthday
     */
		private Date birth;
    /**
     * City
     */
		private String city;
    /**
     * Occupation
     */
		private String job;
    /**
     * bio
     */
		private String bio;
    /**
     * How the user know us
     */
		private Integer referSource;
    /**
     * membership_point
     */
		private Integer membershipPoint;
    /**
     * reward_point
     */
		private Integer rewardPoint;
    /**
     * Status
     */
		private Integer status;
    /**
     * Registration date
     */
		private Date registrationDate;
}