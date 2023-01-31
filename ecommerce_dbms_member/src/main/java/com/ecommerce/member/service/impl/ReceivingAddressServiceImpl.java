package com.ecommerce.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.member.dao.ReceivingAddressDao;
import com.ecommerce.member.dto.ReceivingAddressDto;
import com.ecommerce.member.entity.ReceivingAddressEntity;
import com.ecommerce.member.service.ReceivingAddressService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class ReceivingAddressServiceImpl extends CrudServiceImpl<ReceivingAddressDao, ReceivingAddressEntity, ReceivingAddressDto> implements ReceivingAddressService {

    @Override
    public QueryWrapper<ReceivingAddressEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<ReceivingAddressEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}