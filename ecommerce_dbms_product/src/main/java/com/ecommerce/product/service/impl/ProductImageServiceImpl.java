package com.ecommerce.product.service.impl;

import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.common.utils.ConvertUtils;
import com.ecommerce.product.dao.ProductImageDao;
import com.ecommerce.product.dto.ProductImageDto;
import com.ecommerce.product.entity.ProductImageEntity;
import com.ecommerce.product.service.ProductImageService;
import com.ecommerce.product.vo.ProductImageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductImageServiceImpl
        extends CrudServiceImpl<ProductImageDao, ProductImageEntity, ProductImageDto, ProductImageVo>
        implements ProductImageService {

    @Autowired
    private ProductImageDao productImageDao;
    @Override
    public List<ProductImageVo> getAllByProductId(Long id) {
        List<ProductImageEntity> entities = productImageDao.getAllByProductId(id);
        entities = entities == null ? new ArrayList<>() : entities;
        return ConvertUtils.sourceToTarget(entities, ProductImageVo.class);
    }

    @Override
    public void removeAllByProductId(List<Long> productIds) {
        productImageDao.removeAllByProductId(productIds);
    }
}