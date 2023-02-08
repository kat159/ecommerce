package com.ecommerce.product.service.impl;

import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.product.dao.ProductDescriptionDao;
import com.ecommerce.product.dto.ProductDescriptionDto;
import com.ecommerce.product.entity.ProductDescriptionEntity;
import com.ecommerce.product.service.ProductDescriptionService;
import com.ecommerce.product.vo.ProductDescriptionVo;
import org.springframework.stereotype.Service;


@Service
public class ProductDescriptionServiceImpl
        extends CrudServiceImpl<ProductDescriptionDao, ProductDescriptionEntity, ProductDescriptionDto, ProductDescriptionVo>
        implements ProductDescriptionService {

}