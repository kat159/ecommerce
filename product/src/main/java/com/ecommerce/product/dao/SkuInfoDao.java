package com.ecommerce.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ecommerce.product.entity.SkuInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * sku信息
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@Mapper
public interface SkuInfoDao extends BaseMapper<SkuInfoEntity> {

}