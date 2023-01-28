package com.ecommerce.warehouse.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.warehouse.dao.WarehouseInfoDao;
import com.ecommerce.warehouse.dto.WarehouseInfoDto;
import com.ecommerce.warehouse.entity.WarehouseInfoEntity;
import com.ecommerce.warehouse.service.WarehouseInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class WarehouseInfoServiceImpl extends CrudServiceImpl<WarehouseInfoDao, WarehouseInfoEntity, WarehouseInfoDto> implements WarehouseInfoService {

    @Override
    public QueryWrapper<WarehouseInfoEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<WarehouseInfoEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}