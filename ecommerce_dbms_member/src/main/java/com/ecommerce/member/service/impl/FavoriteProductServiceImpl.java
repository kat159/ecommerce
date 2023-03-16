package com.ecommerce.member.service.impl;

import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.member.dao.FavoriteProductDao;
import com.ecommerce.member.dto.FavoriteProductDto;
import com.ecommerce.member.entity.FavoriteProductEntity;
import com.ecommerce.member.service.FavoriteProductService;
import com.ecommerce.member.vo.FavoriteProductVo;
import org.springframework.stereotype.Service;


@Service
public class FavoriteProductServiceImpl
        extends CrudServiceImpl<FavoriteProductDao, FavoriteProductEntity, FavoriteProductDto, FavoriteProductVo>
        implements FavoriteProductService {

}