package com.ecommerce.member.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.member.entity.MemberSkuCartEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface MemberSkuCartDao extends BaseDao<MemberSkuCartEntity> {

    @Select("SELECT * FROM member_sku_cart WHERE member_id = #{id} AND sku_id = #{skuId} LIMIT 1")
    MemberSkuCartEntity selectByMemberIdAndSkuId(Long id, Long skuId);
}