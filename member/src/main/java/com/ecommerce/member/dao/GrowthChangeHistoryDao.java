package com.ecommerce.member.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ecommerce.member.entity.GrowthChangeHistoryEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 成长值变化历史记录
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@Mapper
public interface GrowthChangeHistoryDao extends BaseMapper<GrowthChangeHistoryEntity> {

}