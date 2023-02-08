package com.ecommerce.product.service;

import com.ecommerce.common.service.CrudService;
import com.ecommerce.product.dto.SkuDto;
import com.ecommerce.product.entity.SkuEntity;
import com.ecommerce.product.vo.SkuVo;


public interface SkuService extends CrudService<SkuEntity, SkuDto, SkuVo> {

}