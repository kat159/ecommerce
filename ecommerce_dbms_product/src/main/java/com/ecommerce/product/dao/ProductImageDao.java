package com.ecommerce.product.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.product.entity.ProductImageEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface ProductImageDao extends BaseDao<ProductImageEntity> {

    @Select("select * from product_image where product_id = #{id}")
    List<ProductImageEntity> getAllByProductId(Long id);


    default void removeAllByProductId(List<Long> productIds) {
        QueryWrapper<ProductImageEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.in(productIds != null && productIds.size() > 0, "product_id", productIds);
        delete(queryWrapper);
    }
}