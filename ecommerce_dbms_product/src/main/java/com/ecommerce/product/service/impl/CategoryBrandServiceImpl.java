package com.ecommerce.product.service.impl;

import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.product.dao.CategoryBrandDao;
import com.ecommerce.product.dto.CategoryBrandDto;
import com.ecommerce.product.entity.CategoryBrandEntity;
import com.ecommerce.product.service.CategoryBrandService;
import com.ecommerce.product.vo.CategoryBrandVo;
import org.springframework.stereotype.Service;


@Service
public class CategoryBrandServiceImpl
        extends CrudServiceImpl<CategoryBrandDao, CategoryBrandEntity, CategoryBrandDto, CategoryBrandVo>
        implements CategoryBrandService {

}