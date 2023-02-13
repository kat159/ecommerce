

package com.ecommerce.common.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.vo.AddResponseVo;

import java.util.List;
import java.util.Map;

/**
 *  CRUD基础服务接口
 */
public interface CrudService<EntityT, DtoT, VoT> {

    // PageData<VoT> page(Map<String, Object> params);
    <P extends PaginationDto> PageData<VoT> page(P params);

    <P extends PaginationDto> PageData<VoT> page(P params, QueryWrapper<EntityT> queryWrapper);
    // List<VoT> list();
    <P extends PaginationDto> List<VoT> getAll();
    <P extends PaginationDto> List<VoT> getAll(QueryWrapper<EntityT> queryWrapper);
    VoT get(Long id);
    Long add(DtoT dto);
    List<Long> addAll(List<DtoT> dtoList);
    void update(DtoT dto);
    void updateAll(List<DtoT> dtoList);
    void removeAll(List<Long> idList);


}