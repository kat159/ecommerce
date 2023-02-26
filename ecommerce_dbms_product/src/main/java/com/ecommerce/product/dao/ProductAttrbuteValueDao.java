package com.ecommerce.product.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.product.entity.ProductAttrbuteValueEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface ProductAttrbuteValueDao extends BaseDao<ProductAttrbuteValueEntity> {

    @Select("SELECT * FROM product_attrbute_value WHERE product_id = #{id}")
    List<ProductAttrbuteValueEntity> getAllByProductId(Long id);

    default void removeAllByProductId(List<Long> productIds) {
        QueryWrapper<ProductAttrbuteValueEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.in(productIds != null && productIds.size() > 0, "product_id", productIds);
        delete(queryWrapper);
    }

    default void removeAllByAttributeId(List<Long> idList) {
        QueryWrapper<ProductAttrbuteValueEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.in(idList != null && idList.size() > 0, "attribute_id", idList);
        delete(queryWrapper);
    }
}