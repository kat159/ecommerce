package com.ecommerce.product.service;

import com.ecommerce.common.page.PageData;
import com.ecommerce.common.service.CrudService;
import com.ecommerce.product.dto.BrandDto;
import com.ecommerce.product.dto.ProductDto;
import com.ecommerce.product.dto.pagination.BrandPaginationDto;
import com.ecommerce.product.entity.BrandEntity;
import com.ecommerce.product.entity.CategoryBrandEntity;
import com.ecommerce.product.vo.BrandVo;
import com.ecommerce.product.vo.ProductVo;

import java.util.List;


public interface BrandService extends CrudService<BrandEntity, BrandDto, BrandVo> {

    List<CategoryBrandEntity> getAllCategoryBrand(Long brandId);

    List<Long> addCategoryBrand(Long brandId, Long categoryId);

    PageData<BrandVo> page(BrandPaginationDto params);

    List<ProductVo> getAllProduct(Long brandId);

    List<Long> addAllProduct(Long brandId, List<ProductDto> productDtoList);
}