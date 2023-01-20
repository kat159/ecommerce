package com.ecommerce.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.product.entity.AttrEntity;

import java.util.Map;

/**
 * 商品属性
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);
}