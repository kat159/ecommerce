package com.ecommerce.product.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.product.entity.SkuAttributeValueEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface SkuAttributeValueDao extends BaseDao<SkuAttributeValueEntity> {

    @Select("select * from sku_attribute_value where sku_id = #{id}")
    List<SkuAttributeValueEntity> getAllBySkuId(Long id);

    default void removeAllBySkuIdList(List<Long> skuIds) {
        if (skuIds == null || skuIds.size() == 0) {
            return;
        }
        QueryWrapper<SkuAttributeValueEntity> wrapper = new QueryWrapper<>();
        wrapper.in("sku_id", skuIds);
        delete(wrapper);
    }

    default void removeAllByAttributeId(List<Long> idList) {
        if (idList == null || idList.size() == 0) {
            return;
        }
        QueryWrapper<SkuAttributeValueEntity> wrapper = new QueryWrapper<>();
        wrapper.in("attribute_id", idList);
        delete(wrapper);
    }
}