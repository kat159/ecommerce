package com.ecommerce.product.dao;

import com.ecommerce.common.dao.BaseDao;
import com.ecommerce.product.entity.SkuImageEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface SkuImageDao extends BaseDao<SkuImageEntity> {


    @Select("select *\n" +
            "    from sku_image inner join sku_sku_image ssi on sku_image.id = ssi.sku_image_id\n" +
            "    inner join sku s on ssi.sku_id = s.id\n" +
            "where s.product_id = #{productId}")
    List<SkuImageEntity> getAllByProductId(Long productId);
}