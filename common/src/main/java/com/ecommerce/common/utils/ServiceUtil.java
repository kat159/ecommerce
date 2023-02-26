package com.ecommerce.common.utils;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ecommerce.common.bo.TreeBo;
import com.ecommerce.common.vo.TreeVo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class ServiceUtil {
    public static <DaoT extends BaseMapper<EntityT>, EntityT, VoT extends TreeVo<VoT>, BoT extends TreeBo<BoT>>
    List<VoT> getForest(DaoT dao, Class<VoT> voClass, Class<BoT> boClass) {

        List<EntityT> entityList = dao.selectList(null);

        return getForest(entityList, voClass, boClass);
    }

    public static <EntityT, VoT extends TreeVo<VoT>, BoT extends TreeBo<BoT>>
    List<VoT> getForest(List<EntityT> entityList, Class<VoT> voClass, Class<BoT> boClass) {

        // convert record list to Bo
        List<BoT> boList = ConvertUtils.sourceToTarget(entityList, boClass);
        // initialize the children list
        for (BoT bo : boList) {
            bo.setChildren(new ArrayList<>());
        }
        // Build Bo Tree
        List<BoT> rootList = buildForest(boList);
        // convert Bo Tree to Vo Tree
        List<VoT> res = convertToVoForest(rootList, voClass);

        return res;
    }

    private static  <BoT extends TreeBo<BoT>> List<BoT> buildForest(List<BoT> boList) {
        List<BoT> rootList = new ArrayList<>();
        Map<Long, BoT> map = new HashMap<>();
        for (BoT bo : boList) {
            
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
                    // 
                } else { // parent deleted
                    // do nothing, all the sub nodes of 'parent' will not be added to the tree
                    // throw new RuntimeException("parent not exists");
                    // TODO: scheduling removing of nodes pointing to deleted parents
                }
            }
        }
        return rootList;
    }

    private static <VoT extends TreeVo<VoT>, BoT extends TreeBo<BoT>> List<VoT> convertToVoForest(List<BoT> boList, Class<VoT> voClass) {
        List<VoT> res = new ArrayList<>();
        for (BoT bo : boList) {
            VoT vo = ConvertUtils.sourceToTarget(bo, voClass);
            vo.setChildren(convertToVoForest(bo.getChildren(), voClass));
            res.add(vo);
        }
        return res;
    }

}
