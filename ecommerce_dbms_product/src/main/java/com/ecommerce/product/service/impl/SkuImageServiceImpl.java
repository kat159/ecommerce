package com.ecommerce.product.service.impl;

import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.product.dao.SkuImageDao;
import com.ecommerce.product.dto.SkuImageDto;
import com.ecommerce.product.entity.SkuImageEntity;
import com.ecommerce.product.service.SkuImageService;
import com.ecommerce.product.vo.SkuImageVo;
import org.springframework.stereotype.Service;


@Service
public class SkuImageServiceImpl
        extends CrudServiceImpl<SkuImageDao, SkuImageEntity, SkuImageDto, SkuImageVo>
        implements SkuImageService {

}