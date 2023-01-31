package com.ecommerce.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.common.service.impl.TreeServiceImpl;
import com.ecommerce.common.utils.ConvertUtils;
import com.ecommerce.product.bo.CategoryBo;
import com.ecommerce.product.dao.CategoryDao;
import com.ecommerce.product.dto.CategoryDto;
import com.ecommerce.product.entity.CategoryEntity;
import com.ecommerce.product.service.CategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class CategoryServiceImpl extends TreeServiceImpl<CategoryDao, CategoryEntity, CategoryDto, CategoryBo>
        implements CategoryService {

    @Override
    public void save(CategoryDto dto) {
        CategoryEntity entity = ConvertUtils.sourceToTarget(dto, currentModelClass());
        // initial soft delete value
        entity.setNonDeleted(1);
        // set level value
        CategoryEntity parent = baseDao.selectById(entity.getParentId());
        Integer parentLevel = parent.getLevel();
        entity.setLevel(parentLevel + 1);

        // TODO: capture it and return detail error to front end
        if (parentLevel + 1 > 3) {
            throw new RuntimeException("Category level can not be more than 3");
        }

        insert(entity);

        //copy主键值到dto
        BeanUtils.copyProperties(entity, dto);
    }

    @Override
    public QueryWrapper<CategoryEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<CategoryEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}