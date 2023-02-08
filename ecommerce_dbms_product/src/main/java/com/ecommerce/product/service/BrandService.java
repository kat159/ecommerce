package com.ecommerce.product.service;

import com.ecommerce.common.service.CrudService;
import com.ecommerce.product.dto.BrandDto;
import com.ecommerce.product.entity.BrandEntity;
import com.ecommerce.product.vo.BrandVo;


public interface BrandService extends CrudService<BrandEntity, BrandDto, BrandVo> {

}