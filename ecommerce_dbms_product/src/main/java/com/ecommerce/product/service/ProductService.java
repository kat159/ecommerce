package com.ecommerce.product.service;

import com.ecommerce.common.page.PageData;
import com.ecommerce.common.service.CrudService;
import com.ecommerce.product.dto.ProductDto;
import com.ecommerce.product.dto.aggregate.ProductManageDto;
import com.ecommerce.product.dto.aggregate.ProductPublishDto;
import com.ecommerce.product.dto.pagination.AttrFilter;
import com.ecommerce.product.dto.pagination.ProductPaginationDto;
import com.ecommerce.product.dto.pagination.ProductSearchParams;
import com.ecommerce.product.entity.ProductEntity;
import com.ecommerce.product.vo.ProductVo;
import com.ecommerce.product.vo.aggregate.ProductSearchVo;

import java.util.List;


public interface ProductService extends CrudService<ProductEntity, ProductDto, ProductVo> {

    @Override
    Long add(ProductDto dto);
    PageData<ProductVo> page(ProductPaginationDto params);
    List<Long> publishAll(List<ProductPublishDto> dtoList);
    void manageAll(List<ProductManageDto> dtoList);

    PageData<ProductSearchVo> search(ProductSearchParams params);

    @Override
    void removeAll(List<Long> ids);

    ProductVo getDetailBySkuId(Long skuId);
}