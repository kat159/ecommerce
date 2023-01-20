package com.ecommerce.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ecommerce.order.entity.RefundInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 退款信息
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@Mapper
public interface RefundInfoDao extends BaseMapper<RefundInfoEntity> {

}