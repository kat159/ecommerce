package com.common.country.service;

import com.ecommerce.common.service.CrudService;
import com.common.country.dto.CitiesDto;
import com.common.country.entity.CitiesEntity;
import com.common.country.vo.CitiesVo;

import java.util.List;


public interface CitiesService extends CrudService<CitiesEntity, CitiesDto, CitiesVo> {

    List<CitiesVo> getAllByStateId(Long id);
}