package com.ecommerce.product.service.impl;

import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.product.dao.CategoryBrandDao;
import com.ecommerce.product.dto.CategoryBrandDto;
import com.ecommerce.product.entity.CategoryBrandEntity;
import com.ecommerce.product.service.CategoryBrandService;
import com.ecommerce.product.vo.CategoryBrandVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryBrandServiceImpl
        extends CrudServiceImpl<CategoryBrandDao, CategoryBrandEntity, CategoryBrandDto, CategoryBrandVo>
        implements CategoryBrandService {

}