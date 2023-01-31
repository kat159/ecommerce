package com.ecommerce.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.member.dao.LoginRecordDao;
import com.ecommerce.member.dto.LoginRecordDto;
import com.ecommerce.member.entity.LoginRecordEntity;
import com.ecommerce.member.service.LoginRecordService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class LoginRecordServiceImpl extends CrudServiceImpl<LoginRecordDao, LoginRecordEntity, LoginRecordDto> implements LoginRecordService {

    @Override
    public QueryWrapper<LoginRecordEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<LoginRecordEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}