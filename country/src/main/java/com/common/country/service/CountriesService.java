package com.common.country.service;

import com.common.country.vo.StatesVo;
import com.ecommerce.common.service.CrudService;
import com.common.country.dto.CountriesDto;
import com.common.country.entity.CountriesEntity;
import com.common.country.vo.CountriesVo;

import java.util.List;


public interface CountriesService extends CrudService<CountriesEntity, CountriesDto, CountriesVo> {
    List<CountriesVo> getAll(List<String> include);

    List<StatesVo> getAllStates(Long id);
}