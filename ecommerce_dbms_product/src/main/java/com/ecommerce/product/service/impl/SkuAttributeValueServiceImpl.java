package com.ecommerce.product.service.impl;

import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.common.utils.ConvertUtils;
import com.ecommerce.product.dao.SkuAttributeValueDao;
import com.ecommerce.product.dto.SkuAttributeValueDto;
import com.ecommerce.product.entity.SkuAttributeValueEntity;
import com.ecommerce.product.service.SkuAttributeValueService;
import com.ecommerce.product.vo.SkuAttributeValueVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SkuAttributeValueServiceImpl
        extends CrudServiceImpl<SkuAttributeValueDao, SkuAttributeValueEntity, SkuAttributeValueDto, SkuAttributeValueVo>
        implements SkuAttributeValueService {
    @Autowired
    private SkuAttributeValueDao skuAttributeValueDao;

    @Override
    public List<SkuAttributeValueVo> getAllBySkuId(Long id) {
        List<SkuAttributeValueEntity> skuAttributeValueEntities = skuAttributeValueDao.getAllBySkuId(id);
        skuAttributeValueEntities = skuAttributeValueEntities == null ? new ArrayList<>() : skuAttributeValueEntities;
        return ConvertUtils.sourceToTarget(skuAttributeValueEntities, SkuAttributeValueVo.class);
    }

    @Override
    public void removeAllBySkuIdList(List<Long> skuIds) {
        if (skuIds == null || skuIds.size() == 0) {
            return;
        }
        skuAttributeValueDao.removeAllBySkuIdList(skuIds);
    }

    @Override
    public void removeAllByAttributeId(List<Long> idList) {
        if (idList == null || idList.size() == 0) {
            return;
        }
        baseDao.removeAllByAttributeId(idList);
    }
}