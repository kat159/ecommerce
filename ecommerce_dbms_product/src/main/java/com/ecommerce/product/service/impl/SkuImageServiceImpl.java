package com.ecommerce.product.service.impl;

import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.common.utils.ConvertUtils;
import com.ecommerce.product.dao.SkuImageDao;
import com.ecommerce.product.dao.SkuSkuImageDao;
import com.ecommerce.product.dto.SkuImageDto;
import com.ecommerce.product.entity.SkuImageEntity;
import com.ecommerce.product.entity.SkuSkuImageEntity;
import com.ecommerce.product.service.SkuImageService;
import com.ecommerce.product.service.SkuSkuImageService;
import com.ecommerce.product.vo.SkuImageVo;
import com.ecommerce.product.vo.SkuSkuImageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SkuImageServiceImpl
        extends CrudServiceImpl<SkuImageDao, SkuImageEntity, SkuImageDto, SkuImageVo>
        implements SkuImageService {

    @Autowired
    private SkuSkuImageService skuSkuImageService;
    @Autowired
    private SkuSkuImageDao skuSkuImageDao;
    @Override
    public void removeAll(List<Long> ids) {
        super.removeAll(ids);
        // remove join table skuSkuImage
        skuSkuImageService.removeAllBySkuImageIds(ids);
    }
    @Override
    public List<SkuImageVo> getAllBySkuId(Long skuId) {
        List<SkuSkuImageEntity> skuSkuImageEntities = skuSkuImageDao.getAllBySkuId(skuId);
        if (skuSkuImageEntities == null || skuSkuImageEntities.size() == 0) {
            return new ArrayList<>();
        }
        List<Long> skuImageIds = skuSkuImageEntities.stream().map(SkuSkuImageEntity::getSkuImageId).collect(Collectors.toList());
        List<SkuImageEntity> skuImageEntities = baseDao.selectBatchIds(skuImageIds);
        if (skuImageEntities == null || skuImageEntities.size() == 0) {
            return new ArrayList<>();
        }
        return ConvertUtils.sourceToTarget(skuImageEntities, SkuImageVo.class);
    }

    @Override
    public void removeAllByProductId(List<Long> ids) {
        if (ids == null || ids.size() == 0) {
            return;
        }
        for (Long productId : ids) {
            List<SkuImageEntity> skuImageEntities = baseDao.getAllByProductId(productId);
            if (skuImageEntities == null || skuImageEntities.size() == 0) {
                continue;
            }
            List<Long> skuImageIds = skuImageEntities.stream().map(SkuImageEntity::getId).collect(Collectors.toList());
            removeAll(skuImageIds);
        }
    }
}