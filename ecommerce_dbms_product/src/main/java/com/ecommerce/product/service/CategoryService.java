package com.ecommerce.product.service;

import com.ecommerce.common.service.CrudService;
import com.ecommerce.common.service.TreeService;
import com.ecommerce.product.dto.CategoryDto;
import com.ecommerce.product.entity.CategoryEntity;


public interface CategoryService extends TreeService<CategoryEntity, CategoryDto> {

}