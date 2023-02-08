package com.ecommerce.common.service;

import java.util.List;

public interface TreeService<EntityT, DtoT, VoT> extends CrudService<EntityT, DtoT, VoT> {

    /**
     * 获取树形数据
     */
    List<VoT> getTree();
}
