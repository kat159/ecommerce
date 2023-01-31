package com.ecommerce.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.order.dao.RefundInfoDao;
import com.ecommerce.order.dto.RefundInfoDto;
import com.ecommerce.order.entity.RefundInfoEntity;
import com.ecommerce.order.service.RefundInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class RefundInfoServiceImpl extends CrudServiceImpl<RefundInfoDao, RefundInfoEntity, RefundInfoDto> implements RefundInfoService {

    @Override
    public QueryWrapper<RefundInfoEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<RefundInfoEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}