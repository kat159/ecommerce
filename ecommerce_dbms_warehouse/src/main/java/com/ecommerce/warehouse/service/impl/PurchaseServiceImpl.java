package com.ecommerce.warehouse.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.warehouse.dao.PurchaseDao;
import com.ecommerce.warehouse.dto.PurchaseDto;
import com.ecommerce.warehouse.entity.PurchaseEntity;
import com.ecommerce.warehouse.service.PurchaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class PurchaseServiceImpl extends CrudServiceImpl<PurchaseDao, PurchaseEntity, PurchaseDto> implements PurchaseService {

    @Override
    public QueryWrapper<PurchaseEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<PurchaseEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}