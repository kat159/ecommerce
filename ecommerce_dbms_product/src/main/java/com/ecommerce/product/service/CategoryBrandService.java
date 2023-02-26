package com.ecommerce.product.service;

import com.ecommerce.common.service.CrudService;
import com.ecommerce.product.dto.CategoryBrandDto;
import com.ecommerce.product.entity.CategoryBrandEntity;
import com.ecommerce.product.vo.CategoryBrandVo;


public interface CategoryBrandService extends CrudService<CategoryBrandEntity, CategoryBrandDto, CategoryBrandVo> {
}