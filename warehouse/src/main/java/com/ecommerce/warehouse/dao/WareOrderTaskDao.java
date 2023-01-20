package com.ecommerce.warehouse.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ecommerce.warehouse.entity.WareOrderTaskEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 库存工作单
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-19
 */
@Mapper
public interface WareOrderTaskDao extends BaseMapper<WareOrderTaskEntity> {

}