package com.ecommerce.product.service.impl;

import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.product.dao.SkuDao;
import com.ecommerce.product.dto.SkuDto;
import com.ecommerce.product.entity.SkuEntity;
import com.ecommerce.product.service.SkuService;
import com.ecommerce.product.vo.SkuVo;
import org.springframework.stereotype.Service;


@Service
public class SkuServiceImpl
        extends CrudServiceImpl<SkuDao, SkuEntity, SkuDto, SkuVo>
        implements SkuService {

}