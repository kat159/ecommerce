package com.ecommerce.member.service;

import com.ecommerce.common.service.CrudService;
import com.ecommerce.member.dto.FavoriteProductDto;
import com.ecommerce.member.entity.FavoriteProductEntity;
import com.ecommerce.member.vo.FavoriteProductVo;


public interface FavoriteProductService extends CrudService<FavoriteProductEntity, FavoriteProductDto, FavoriteProductVo> {

}