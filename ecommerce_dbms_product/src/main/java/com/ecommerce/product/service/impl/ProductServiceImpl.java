package com.ecommerce.product.service.impl;

import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.product.dao.ProductDao;
import com.ecommerce.product.dto.ProductDto;
import com.ecommerce.product.entity.ProductEntity;
import com.ecommerce.product.service.ProductService;
import com.ecommerce.product.vo.ProductVo;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl
        extends CrudServiceImpl<ProductDao, ProductEntity, ProductDto, ProductVo>
        implements ProductService {

}