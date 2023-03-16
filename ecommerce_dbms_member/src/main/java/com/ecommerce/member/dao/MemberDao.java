package com.ecommerce.member.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.member.entity.MemberEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface MemberDao extends BaseDao<MemberEntity> {


    @Select("select * from member where username = #{username}")
    MemberEntity getByUsername(String username);
}