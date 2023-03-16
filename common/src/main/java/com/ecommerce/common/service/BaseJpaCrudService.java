package com.ecommerce.common.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;

import java.io.Serializable;
import java.util.List;

public interface BaseJpaCrudService<EntityT, DtoT, VoT, ID extends Serializable> {
    VoT get(ID id);
    <P extends PaginationDto> PageData<VoT> page(P params);
    List<VoT> getAll();
    <P extends PaginationDto> List<VoT> getAll(P pagination);
    void saveAll(List<DtoT> dtoList);
    // List<Long> addAll(List<DtoT> dtoList);
    // void updateAll(List<DtoT> dtoList);
    void removeAll(List<ID> idList);
}
