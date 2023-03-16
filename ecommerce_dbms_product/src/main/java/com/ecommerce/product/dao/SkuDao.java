package com.ecommerce.product.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.product.entity.SkuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Mapper
public interface SkuDao extends BaseDao<SkuEntity> {

    @Select("SELECT * FROM sku WHERE product_id = #{id}")
    List<SkuEntity> getAllByProductId(Long id);

    default List<SkuEntity> selectByProductIdListAndPriceRange(
            List<Long> productIdList,
            BigDecimal minPrice,
            BigDecimal maxPrice) {
        QueryWrapper<SkuEntity> wrapper = new QueryWrapper<>();
        wrapper.in(productIdList != null && !productIdList.isEmpty(), "product_id", productIdList);
        wrapper.ge(minPrice != null, "price", minPrice);
        wrapper.le(maxPrice != null, "price", maxPrice);
        List<SkuEntity> skuEntities = selectList(wrapper);
        return skuEntities == null ? new ArrayList<>() : skuEntities;
    }

    default void removeAllByProductId(List<Long> productIds) {
        if (productIds == null || productIds.size() == 0) {
            return;
        }
        QueryWrapper<SkuEntity> wrapper = new QueryWrapper<>();
        wrapper.in("product_id", productIds);
        delete(wrapper);
    }

    default List<Long> getAllSkuIdsByProductIdList(List<Long> productIds) {
        if (productIds == null || productIds.size() == 0) {
            return new ArrayList<>();
        }
        QueryWrapper<SkuEntity> wrapper = new QueryWrapper<>();
        wrapper.in("product_id", productIds);
        wrapper.select("id");
        List<SkuEntity> skuEntities = selectList(wrapper);
        return skuEntities == null ? new ArrayList<>() : skuEntities.stream().map(SkuEntity::getId).collect(Collectors.toList());
    }

    @Update("UPDATE sku SET stock = stock - #{quantity} WHERE id = #{skuId} AND stock >= #{quantity}")
    Integer deductInventory(Long skuId, Long quantity);

    @Update("UPDATE sku SET stock = stock + #{quantity} WHERE id = #{skuId}")
    void addInventory(Long skuId, Long quantity);
}