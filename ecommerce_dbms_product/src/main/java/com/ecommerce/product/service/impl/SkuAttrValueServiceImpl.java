package com.ecommerce.product.service.impl;

import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.product.dao.SkuAttrValueDao;
import com.ecommerce.product.dto.SkuAttrValueDto;
import com.ecommerce.product.entity.SkuAttrValueEntity;
import com.ecommerce.product.service.SkuAttrValueService;
import com.ecommerce.product.vo.SkuAttrValueVo;
import org.springframework.stereotype.Service;


@Service
public class SkuAttrValueServiceImpl
        extends CrudServiceImpl<SkuAttrValueDao, SkuAttrValueEntity, SkuAttrValueDto, SkuAttrValueVo>
        implements SkuAttrValueService {

}