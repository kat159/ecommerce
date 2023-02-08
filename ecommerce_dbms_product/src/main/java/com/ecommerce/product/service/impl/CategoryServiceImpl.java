package com.ecommerce.product.service.impl;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.common.utils.ConvertUtils;
import com.ecommerce.common.utils.ServiceUtil;
import com.ecommerce.common.vo.AddResponseVo;
import com.ecommerce.product.bo.CategoryTreeBo;
import com.ecommerce.product.dao.CategoryDao;
import com.ecommerce.product.dto.AttributeGroupDto;
import com.ecommerce.product.dto.CategoryDto;
import com.ecommerce.product.entity.CategoryEntity;
import com.ecommerce.product.service.AttributeGroupService;
import com.ecommerce.product.service.CategoryService;
import com.ecommerce.product.vo.AttributeGroupVo;
import com.ecommerce.product.vo.CategoryTreeVo;
import com.ecommerce.product.vo.CategoryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryServiceImpl
        extends CrudServiceImpl<CategoryDao, CategoryEntity, CategoryDto, CategoryVo>
        implements CategoryService {

    @Autowired
    private AttributeGroupService attributeGroupService;

    @Override
    public List<Long> addAll(List<CategoryDto> dtoList) {
        List<CategoryEntity> entityList = ConvertUtils.sourceToTarget(dtoList, CategoryEntity.class);
        List<Long> idList = new ArrayList<>();
        entityList.forEach(entity -> {
            entity.setNonDeleted(1);
            if (entity.getLevel() == null) {
                entity.setLevel(get(entity.getParentId()).getLevel() + 1);
            }
            baseDao.insert(entity);
            idList.add(entity.getId());
        });
        return idList;
    }

    @Override
    public List<CategoryTreeVo> getForest() {
        return ServiceUtil.getForest(baseDao, CategoryTreeVo.class, CategoryTreeBo.class);
    }

    /**
     * Relational: One to Many AttributeGroup
     */
    @Override
    public PageData<AttributeGroupVo> pageAttrGroups(Long categoryId, PaginationDto paginationDto) {
        return attributeGroupService.pageByCategoryId(categoryId, paginationDto);
    }

    @Override
    public List<AttributeGroupVo> getAllAttrGroups(Long categoryId, PaginationDto paginationDto) {
        return attributeGroupService.getAllByCategoryId(categoryId, paginationDto);
    }

    @Override
    public void addAllAttrGroup(Long categoryId, List<AttributeGroupDto> attributeGroupDtoList) {
        attributeGroupDtoList.forEach(attributeGroupDto -> attributeGroupDto.setCategoryId(categoryId));
        attributeGroupService.addAll(attributeGroupDtoList);
    }
}