

package com.ecommerce.common.service;

import com.ecommerce.common.page.PageData;

import java.util.List;
import java.util.Map;

/**
 *  CRUD基础服务接口
 */
public interface CrudService<EntityT, DtoT> extends BaseService<EntityT> {

    PageData<DtoT> page(Map<String, Object> params);

    List<DtoT> list(Map<String, Object> params);

    DtoT get(Long id);

    void save(DtoT dto);

    void update(DtoT dto);

    void delete(Long[] ids);

}