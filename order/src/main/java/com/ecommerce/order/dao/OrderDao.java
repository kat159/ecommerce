package com.ecommerce.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ecommerce.order.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {

}