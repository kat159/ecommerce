package com.ecommerce.coupon.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ecommerce.coupon.entity.MemberPriceEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品会员价格
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@Mapper
public interface MemberPriceDao extends BaseMapper<MemberPriceEntity> {

}