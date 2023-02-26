package com.ecommerce.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.constant.Constant;
import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.common.utils.ConvertUtils;
import com.ecommerce.common.utils.ServiceUtil;
import com.ecommerce.product.bo.CategoryTreeBo;
import com.ecommerce.product.dao.AttributeDao;
import com.ecommerce.product.dao.AttributeGroupDao;
import com.ecommerce.product.dao.CategoryDao;
import com.ecommerce.product.dto.AttributeGroupDto;
import com.ecommerce.product.dto.CategoryDto;
import com.ecommerce.product.dto.pagination.CategoryPaginationDto;
import com.ecommerce.product.entity.AttributeEntity;
import com.ecommerce.product.entity.AttributeGroupEntity;
import com.ecommerce.product.entity.CategoryEntity;
import com.ecommerce.product.service.AttributeGroupService;
import com.ecommerce.product.service.AttributeService;
import com.ecommerce.product.service.CategoryService;
import com.ecommerce.product.vo.AttributeGroupVo;
import com.ecommerce.product.vo.AttributeVo;
import com.ecommerce.product.vo.CategoryTreeVo;
import com.ecommerce.product.vo.CategoryVo;
import com.ecommerce.product.vo.category.AttrGroupWithAttrVo;
import com.mysql.cj.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class CategoryServiceImpl
        extends CrudServiceImpl<CategoryDao, CategoryEntity, CategoryDto, CategoryVo>
        implements CategoryService {

    @Autowired
    private AttributeGroupService attributeGroupService;
    @Autowired
    private AttributeService attributeService;
    @Autowired
    private AttributeGroupDao attributeGroupDao;
    @Autowired
    private AttributeDao attributeDao;

    @Autowired
    private CategoryDao categoryDao;
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
    public void removeAll(List<Long> idList) {
        for (Long id : idList) {
            List<CategoryEntity> children = categoryDao.selectByParentId(id);
            List<Long> childrenIdList = children.stream().map(child -> child.getId()).collect(Collectors.toList());
            removeAll(childrenIdList);
            baseDao.deleteById(id);
        }
    }
    @Override
    public List<CategoryTreeVo> getForest() {
        return ServiceUtil.getForest(baseDao, CategoryTreeVo.class, CategoryTreeBo.class);
    }

    @Override
    public List<CategoryVo> getAll(CategoryPaginationDto paginationDto) {
        QueryWrapper<CategoryEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(paginationDto.getLevel() != null,"level", paginationDto.getLevel());
        // search name prefix
        queryWrapper.likeRight(!StringUtils.isNullOrEmpty(paginationDto.getName()),"name", paginationDto.getName());
        List<CategoryEntity> entityList = baseDao.selectList(queryWrapper);
        // delete invalid category
        for (CategoryEntity entity : entityList) {
            CategoryEntity current = entity;
            while (current.getParentId() != 0) {
                current = baseDao.selectById(current.getParentId());
                if (current == null) {
                    baseDao.deleteById(entity.getId());
                    break;
                }
            }
        }
        return ConvertUtils.sourceToTarget(entityList, CategoryVo.class);
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
        List<AttributeGroupVo> attrGroupVos = attributeGroupService.getAllByCategoryId(categoryId, null);
        List<String> includes = paginationDto.getInclude();
        if (includes != null && includes.contains("attr")) {
            for (AttributeGroupVo attrGroupVo : attrGroupVos) {
                List<AttributeVo> attrVos = attributeService.getAllByAttributeGroupId(attrGroupVo.getId(), null);
                attrGroupVo.setAttributes(attrVos);
            }
        }
        return attrGroupVos;
    }

    @Override
    public List<Long> addAllAttrGroup(Long categoryId, List<AttributeGroupDto> attributeGroupDtoList) {
        attributeGroupDtoList.forEach(attributeGroupDto -> attributeGroupDto.setCategoryId(categoryId));
        return attributeGroupService.addAll(attributeGroupDtoList);
    }

    @Override
    public List<AttrGroupWithAttrVo> getAllAttrGroupWithAttrList(Long categoryId) {
        System.out.println("get attrgroups：" + categoryId);
        List<AttributeGroupEntity> attrGroups = attributeGroupDao.selectByCategoryId(categoryId);
        System.out.println("get attrgroups：" + attrGroups);
        List<AttrGroupWithAttrVo> attrGroupWithAttrVoList = new ArrayList<>();
        for (AttributeGroupEntity attrGroup : attrGroups) {// set attrGroup info
            AttrGroupWithAttrVo attrGroupWithAttrVo = new AttrGroupWithAttrVo();
            attrGroupWithAttrVo.setId(attrGroup.getId());
            attrGroupWithAttrVo.setName(attrGroup.getName());

            // set attributes of this attrGroup
            attrGroupWithAttrVo.setSaleAttrs(new ArrayList<>());
            attrGroupWithAttrVo.setSpecAttrs(new ArrayList<>());

            List<AttributeEntity> attributes = attributeDao.selectByAttrGroupId(attrGroup.getId());
            System.out.println("attrGroup id：" + attrGroup.getId() + "");
            System.out.println("get attributes ：" + attributes);
            for (AttributeEntity attr : attributes) {
                Long attrId = attr.getId();
                String attrName = attr.getName();
                String attrValueList = attr.getSelectableValueList();
                String[] selectableValueList = attrValueList == null ? new String[0] : attrValueList.split(Constant.STRING_SEPARATOR);

                if (attr.getType() == 0) { // sale
                    attrGroupWithAttrVo.addSaleAttr(attrId, attrName, selectableValueList);
                } else if (attr.getType() == 1) { // spec
                    attrGroupWithAttrVo.addSpecAttr(attrId, attrName, selectableValueList);
                } else if (attr.getType() == 2) { // both
                    attrGroupWithAttrVo.addCommonAttr(attrId, attrName, selectableValueList);
                } else {
                    log.error("Attribute type error, not in [0, 1, 2], attr type:  " + attr.getType());
                }
            }
            attrGroupWithAttrVoList.add(attrGroupWithAttrVo);
        }
        return attrGroupWithAttrVoList;
    }
}