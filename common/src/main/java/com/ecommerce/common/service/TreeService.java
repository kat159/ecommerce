package com.ecommerce.common.service;

import java.util.List;

public interface TreeService<EntityT, DtoT> extends CrudService<EntityT, DtoT> {

        /**
        * 获取树形数据
        */
        List<DtoT> getTree();
}
