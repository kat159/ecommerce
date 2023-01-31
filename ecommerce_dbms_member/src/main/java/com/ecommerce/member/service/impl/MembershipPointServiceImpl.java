package com.ecommerce.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.member.dao.MembershipPointDao;
import com.ecommerce.member.dto.MembershipPointDto;
import com.ecommerce.member.entity.MembershipPointEntity;
import com.ecommerce.member.service.MembershipPointService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class MembershipPointServiceImpl extends CrudServiceImpl<MembershipPointDao, MembershipPointEntity, MembershipPointDto> implements MembershipPointService {

    @Override
    public QueryWrapper<MembershipPointEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<MembershipPointEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}