package com.common.country.service;

import com.common.country.vo.CitiesVo;
import com.ecommerce.common.service.CrudService;
import com.common.country.dto.StatesDto;
import com.common.country.entity.StatesEntity;
import com.common.country.vo.StatesVo;

import java.util.List;


public interface StatesService extends CrudService<StatesEntity, StatesDto, StatesVo> {

    List<StatesVo> getAllByCountryId(Long id);

    List<CitiesVo> getAllCities(Long id);
}