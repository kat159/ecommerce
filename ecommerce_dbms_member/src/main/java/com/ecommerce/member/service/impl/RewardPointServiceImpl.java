package com.ecommerce.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.member.dao.RewardPointDao;
import com.ecommerce.member.dto.RewardPointDto;
import com.ecommerce.member.entity.RewardPointEntity;
import com.ecommerce.member.service.RewardPointService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class RewardPointServiceImpl extends CrudServiceImpl<RewardPointDao, RewardPointEntity, RewardPointDto> implements RewardPointService {

    @Override
    public QueryWrapper<RewardPointEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<RewardPointEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}