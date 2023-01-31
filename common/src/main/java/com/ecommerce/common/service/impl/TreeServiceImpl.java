package com.ecommerce.common.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.ecommerce.common.bo.TreeBo;
import com.ecommerce.common.dto.TreeDto;
import com.ecommerce.common.service.TreeService;
import com.ecommerce.common.utils.ConvertUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class TreeServiceImpl<M extends BaseMapper<EntityT>, EntityT, DtoT extends TreeDto<DtoT>, BoT extends TreeBo<BoT>>
        extends CrudServiceImpl<M, EntityT, DtoT>
        implements TreeService<EntityT, DtoT> {

    @Override
    public List<DtoT> getTree() {
        // get all records
        List<EntityT> entityList = baseDao.selectList(null);

        // convert record list to Bo
        List<BoT> boList = ConvertUtils.sourceToTarget(entityList, currentBoClass());
        // initialize the children list
        for (BoT bo : boList) {
            bo.setChildren(new ArrayList<>());
        }

        // Build Bo Tree
        List<BoT> rootList = buildTree(boList);

        // convert Bo Tree to Dto Tree
        List<DtoT> res = convertToDtoList(rootList);

        return res;
    }

    private List<DtoT> convertToDtoList(List<BoT> boList) {
        List<DtoT> res = new ArrayList<>();
        for (BoT bo : boList) {
            DtoT dto = ConvertUtils.sourceToTarget(bo, currentDtoClass());
            dto.setChildren(convertToDtoList(bo.getChildren()));
            res.add(dto);
        }
        return res;
    }

    private Class<BoT> currentBoClass() {
        return (Class<BoT>) ReflectionKit.getSuperClassGenericType(getClass(), TreeServiceImpl.class, 3);
    }

    private List<BoT> buildTree(List<BoT> dtoList) {
        List<BoT> rootList = new ArrayList<>();
        Map<Long, BoT> map = new HashMap<>();
        for (BoT dto : dtoList) {
            System.out.println(dto.getId() + ", " + dto.getParentId());
            map.put(dto.getId(), dto);
        }
        for (BoT dto : dtoList) {
            if (dto.getParentId() == 0) { // root
                rootList.add(dto);
            } else { // not root --> has parent
                BoT parent = map.get(dto.getParentId());
                if (parent != null) {
                    parent.addChild(dto);
                    // System.out.println("parent: " + parent);
                } else {
                    // do nothing, all the sub nodes of 'parent' will not be added to the tree
                    // throw new RuntimeException("parent not exists");
                }
            }
        }
        return rootList;
    }
}
