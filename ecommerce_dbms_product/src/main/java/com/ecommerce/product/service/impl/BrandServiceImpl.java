package com.ecommerce.product.service.impl;

import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.product.dao.BrandDao;
import com.ecommerce.product.dto.BrandDto;
import com.ecommerce.product.entity.BrandEntity;
import com.ecommerce.product.service.BrandService;
import com.ecommerce.product.vo.BrandVo;
import org.springframework.stereotype.Service;


@Service
public class BrandServiceImpl
        extends CrudServiceImpl<BrandDao, BrandEntity, BrandDto, BrandVo>
        implements BrandService {

}