package com.ecommerce.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("favorite_product")
public class FavoriteProductEntity {

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
     * Product ID
     */
		private Long productId;
    /**
     * Product name
     */
		private String productName;
    /**
     * Product image
     */
		private String productImg;
    /**
     * Date added to favorites
     */
		private Date addDate;
}