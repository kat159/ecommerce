package com.ecommerce.product.service.impl;

import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.product.dao.ProductAttrbuteValueDao;
import com.ecommerce.product.dto.ProductAttrbuteValueDto;
import com.ecommerce.product.entity.ProductAttrbuteValueEntity;
import com.ecommerce.product.service.ProductAttrbuteValueService;
import com.ecommerce.product.vo.ProductAttrbuteValueVo;
import org.springframework.stereotype.Service;


@Service
public class ProductAttrbuteValueServiceImpl
        extends CrudServiceImpl<ProductAttrbuteValueDao, ProductAttrbuteValueEntity, ProductAttrbuteValueDto, ProductAttrbuteValueVo>
        implements ProductAttrbuteValueService {

}