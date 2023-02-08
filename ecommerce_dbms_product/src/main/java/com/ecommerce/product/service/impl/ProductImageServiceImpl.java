package com.ecommerce.product.service.impl;

import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.product.dao.ProductImageDao;
import com.ecommerce.product.dto.ProductImageDto;
import com.ecommerce.product.entity.ProductImageEntity;
import com.ecommerce.product.service.ProductImageService;
import com.ecommerce.product.vo.ProductImageVo;
import org.springframework.stereotype.Service;


@Service
public class ProductImageServiceImpl
        extends CrudServiceImpl<ProductImageDao, ProductImageEntity, ProductImageDto, ProductImageVo>
        implements ProductImageService {

}