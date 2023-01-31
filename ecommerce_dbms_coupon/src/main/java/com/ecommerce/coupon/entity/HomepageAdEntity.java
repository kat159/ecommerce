package com.ecommerce.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("homepage_ad")
public class HomepageAdEntity {

    /**
     * id
     */
		@TableId
		private Long id;
    /**
     * Name
     */
		private String name;
    /**
     * Image URL
     */
		private String pic;
    /**
     * Start Time
     */
		private Date startTime;
    /**
     * End Time
     */
		private Date endTime;
    /**
     * Status
     */
		private Integer status;
    /**
     * Click Count
     */
		private Integer clickCount;
    /**
     * Ad redirected Link
     */
		private String url;
    /**
     * remark
     */
		private String remark;
    /**
     * Sort
     */
		private Integer sort;
    /**
     * Publisher
     */
		private Long publisherId;
    /**
     * Person who censored the ad
     */
		private Long censorId;
}