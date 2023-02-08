package com.ecommerce.common.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.ecommerce.common.bo.TreeBo;
import com.ecommerce.common.dto.BaseDto;
import com.ecommerce.common.entity.BaseEntity;
import com.ecommerce.common.service.TreeService;
import com.ecommerce.common.utils.ConvertUtils;
import com.ecommerce.common.vo.TreeVo;
import com.sun.jdi.InternalException;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public abstract class TreeServiceImpl <
            DaoT extends BaseMapper<EntityT>,
            EntityT extends BaseEntity<EntityT>,
            DtoT extends BaseDto<DtoT>,
            VoT extends TreeVo<VoT>,
            BoT extends TreeBo<BoT>>
        extends CrudServiceImpl<DaoT, EntityT, DtoT, VoT>
        implements TreeService<EntityT, DtoT, VoT>
{

    public List<VoT> getTree() {
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
        // convert Bo Tree to Vo Tree
        List<VoT> res = convertToVoTree(rootList);

        return res;
    }

    private List<BoT> buildTree(List<BoT> boList) {
        List<BoT> rootList = new ArrayList<>();
        Map<Long, BoT> map = new HashMap<>();
        for (BoT bo : boList) {
            System.out.println(bo.getId() + ", " + bo.getParentId());
            map.put(bo.getId(), bo);
        }
        for (BoT bo : boList) {
            if (bo.getParentId() == null) {
                log.error("parent id is null, at category: {}", bo);
                continue;
            }
            if (bo.getParentId() == 0) { // root
                rootList.add(bo);
            } else { // not root --> has parent
                BoT parent = map.get(bo.getParentId());
                if (parent != null) { // parent exists
                    parent.addChild(bo);
                    // System.out.println("parent: " + parent);
                } else { // parent deleted
                    // do nothing, all the sub nodes of 'parent' will not be added to the tree
                    // throw new RuntimeException("parent not exists");
                    // TODO: scheduling removing of nodes pointing to deleted parents
                }
            }
        }
        return rootList;
    }

    private List<VoT> convertToVoTree(List<BoT> boList) {
        List<VoT> res = new ArrayList<>();
        for (BoT bo : boList) {
            VoT vo = ConvertUtils.sourceToTarget(bo, currentVoClass());
            vo.setChildren(convertToVoTree(bo.getChildren()));
            res.add(vo);
        }
        return res;
    }

    private Class<BoT> currentBoClass() {
        return (Class<BoT>) ReflectionKit.getSuperClassGenericType(getClass(), TreeServiceImpl.class, 4);
    }
    private Class<VoT> currentVoClass() {
        return (Class<VoT>) ReflectionKit.getSuperClassGenericType(getClass(), TreeServiceImpl.class, 3);
    }
    private Class<DtoT> currentDtoClass() {
        return (Class<DtoT>) ReflectionKit.getSuperClassGenericType(getClass(), CrudServiceImpl.class, 2);
    }

    private Class<EntityT> currentEntityClass() {
        return (Class<EntityT>)ReflectionKit.getSuperClassGenericType(this.getClass(), CrudServiceImpl.class, 1);
    }
}
