package com.ecommerce.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.product.dao.ProductCommentDao;
import com.ecommerce.product.dto.ProductCommentDto;
import com.ecommerce.product.entity.ProductCommentEntity;
import com.ecommerce.product.service.ProductCommentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class ProductCommentServiceImpl extends CrudServiceImpl<ProductCommentDao, ProductCommentEntity, ProductCommentDto> implements ProductCommentService {

    @Override
    public QueryWrapper<ProductCommentEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<ProductCommentEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}