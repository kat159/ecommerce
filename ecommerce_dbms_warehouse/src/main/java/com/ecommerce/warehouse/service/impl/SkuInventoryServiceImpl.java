package com.ecommerce.warehouse.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.warehouse.dao.SkuInventoryDao;
import com.ecommerce.warehouse.dto.SkuInventoryDto;
import com.ecommerce.warehouse.entity.SkuInventoryEntity;
import com.ecommerce.warehouse.service.SkuInventoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class SkuInventoryServiceImpl extends CrudServiceImpl<SkuInventoryDao, SkuInventoryEntity, SkuInventoryDto> implements SkuInventoryService {

    @Override
    public QueryWrapper<SkuInventoryEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<SkuInventoryEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}