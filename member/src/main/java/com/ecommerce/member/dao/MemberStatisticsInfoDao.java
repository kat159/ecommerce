package com.ecommerce.member.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ecommerce.member.entity.MemberStatisticsInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员统计信息
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
@Mapper
public interface MemberStatisticsInfoDao extends BaseMapper<MemberStatisticsInfoEntity> {

}