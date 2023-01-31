package com.ecommerce.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("receiving_address")
public class ReceivingAddressEntity {

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
     * Receiver Name
     */
		private String name;
    /**
     * Tele number
     */
		private String tele;
    /**
     * Postal Code
     */
		private String postcode;
    /**
     * Province/Metropolis
     */
		private String province;
    /**
     * City
     */
		private String city;
    /**
     * Region
     */
		private String region;
    /**
     * Detail address(street)
     */
		private String address;
}