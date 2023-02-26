package com.ecommerce.product.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.common.utils.Query;
import com.ecommerce.product.entity.SkuSkuImageEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface SkuSkuImageDao extends BaseDao<SkuSkuImageEntity> {

    @Select("SELECT * FROM sku_sku_image WHERE sku_id = #{id}")
    List<SkuSkuImageEntity> getAllBySkuId(Long id);

    default void removeAllBySkuImageIds(List<Long> skuImageIds) {
        if (skuImageIds == null || skuImageIds.size() == 0) {
            return;
        }
        QueryWrapper<SkuSkuImageEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("sku_image_id", skuImageIds);
        delete(queryWrapper);
    }

    default void removeAllBySkuIdList(List<Long> skuIds) {
        if (skuIds == null || skuIds.size() == 0) {
            return;
        }
        QueryWrapper<SkuSkuImageEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("sku_id", skuIds);
        delete(queryWrapper);
    }
}