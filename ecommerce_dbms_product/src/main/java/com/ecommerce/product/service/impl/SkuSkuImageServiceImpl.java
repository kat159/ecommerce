package com.ecommerce.product.service.impl;

import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.common.utils.ConvertUtils;
import com.ecommerce.product.dao.SkuImageDao;
import com.ecommerce.product.dao.SkuSkuImageDao;
import com.ecommerce.product.dto.SkuSkuImageDto;
import com.ecommerce.product.entity.SkuImageEntity;
import com.ecommerce.product.entity.SkuSkuImageEntity;
import com.ecommerce.product.service.SkuSkuImageService;
import com.ecommerce.product.vo.SkuSkuImageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Service
public class SkuSkuImageServiceImpl
        extends CrudServiceImpl<SkuSkuImageDao, SkuSkuImageEntity, SkuSkuImageDto, SkuSkuImageVo>
        implements SkuSkuImageService {

    @Autowired
    private SkuSkuImageDao skuSkuImageDao;
    @Autowired
    private SkuImageDao skuImageDao;
    @Override
    public List<SkuSkuImageVo> getAllBySkuId(Long id) {
        List<SkuSkuImageEntity> skuSkuImageEntityList = skuSkuImageDao.getAllBySkuId(id);
        List<SkuSkuImageVo> skuSkuImageVoList = ConvertUtils.sourceToTarget(skuSkuImageEntityList, SkuSkuImageVo.class);
        return skuSkuImageVoList == null ? new ArrayList<>() : skuSkuImageVoList;
    }

    @Override
    public void removeAllBySkuImageIds(List<Long> skuImageIds) {
        skuSkuImageDao.removeAllBySkuImageIds(skuImageIds);
    }

    @Override
    public void removeAllBySkuIdList(List<Long> skuIds) {
        if (skuIds == null || skuIds.size() == 0) {
            return;
        }
        skuSkuImageDao.removeAllBySkuIdList(skuIds);
    }

}