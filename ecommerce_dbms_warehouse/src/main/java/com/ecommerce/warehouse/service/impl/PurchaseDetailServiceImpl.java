package com.ecommerce.warehouse.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.warehouse.dao.PurchaseDetailDao;
import com.ecommerce.warehouse.dto.PurchaseDetailDto;
import com.ecommerce.warehouse.entity.PurchaseDetailEntity;
import com.ecommerce.warehouse.service.PurchaseDetailService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class PurchaseDetailServiceImpl extends CrudServiceImpl<PurchaseDetailDao, PurchaseDetailEntity, PurchaseDetailDto> implements PurchaseDetailService {

    @Override
    public QueryWrapper<PurchaseDetailEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<PurchaseDetailEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}