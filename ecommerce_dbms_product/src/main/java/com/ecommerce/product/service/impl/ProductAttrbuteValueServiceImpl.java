package com.ecommerce.product.service.impl;

import com.ecommerce.common.constant.Constant;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.common.utils.ConvertUtils;
import com.ecommerce.product.dao.ProductAttrbuteValueDao;
import com.ecommerce.product.dto.ProductAttrbuteValueDto;
import com.ecommerce.product.entity.ProductAttrbuteValueEntity;
import com.ecommerce.product.service.AttributeService;
import com.ecommerce.product.service.ProductAttrbuteValueService;
import com.ecommerce.product.vo.AttributeVo;
import com.ecommerce.product.vo.ProductAttrbuteValueVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductAttrbuteValueServiceImpl
        extends CrudServiceImpl<ProductAttrbuteValueDao, ProductAttrbuteValueEntity, ProductAttrbuteValueDto, ProductAttrbuteValueVo>
        implements ProductAttrbuteValueService {

    @Autowired
    private ProductAttrbuteValueDao productAttrbuteValueDao;
    @Autowired
    private AttributeService attributeService;

    @Override
    public List<ProductAttrbuteValueVo> getAllByProductId(Long id) {
        List<ProductAttrbuteValueEntity> productAttrbuteValueEntities = productAttrbuteValueDao.getAllByProductId(id);
        productAttrbuteValueEntities = productAttrbuteValueEntities == null ? new ArrayList<>() : productAttrbuteValueEntities;

        List<ProductAttrbuteValueVo> productAttrbuteValueVos = ConvertUtils.sourceToTarget(productAttrbuteValueEntities, ProductAttrbuteValueVo.class);
        for (ProductAttrbuteValueVo productAttrbuteValueVo : productAttrbuteValueVos) {
            if (productAttrbuteValueVo.getAttributeValue() != null) {
                productAttrbuteValueVo.setAttributeValueList(productAttrbuteValueVo.getAttributeValue().split(Constant.STRING_SEPARATOR));
            }
            AttributeVo attributeVo = attributeService.get(productAttrbuteValueVo.getAttributeId());
            if (attributeVo == null) {
                continue;
            }
            productAttrbuteValueVo.setAttributeName(attributeVo.getName());
            productAttrbuteValueVo.setAttributeType(attributeVo.getType());
        }
        return productAttrbuteValueVos;
    }

    @Override
    public void removeAllByProductId(List<Long> productIds) {
        baseDao.removeAllByProductId(productIds);
    }

    @Override
    public void removeAllByAttributeId(List<Long> idList) {
        baseDao.removeAllByAttributeId(idList);
    }
}