package com.ecommerce.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.product.entity.AttrGroupEntity;

import java.util.Map;

/**
 * 属性分组
 *
 * @author allen xh1300092517@gmail.com
 * @since 1.0.0 2023-01-18
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);
}