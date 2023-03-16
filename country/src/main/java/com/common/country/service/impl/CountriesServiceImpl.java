package com.common.country.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.common.country.service.StatesService;
import com.common.country.vo.StatesVo;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.common.country.dao.CountriesDao;
import com.common.country.dto.CountriesDto;
import com.common.country.entity.CountriesEntity;
import com.common.country.service.CountriesService;
import com.common.country.vo.CountriesVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CountriesServiceImpl
        extends CrudServiceImpl<CountriesDao, CountriesEntity, CountriesDto, CountriesVo>
        implements CountriesService {

    @Autowired
    private StatesService statesService;
    @Override
    public List<CountriesVo> getAll(List<String> include) {
        QueryWrapper<CountriesEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name", "phonecode", "iso3");
        if (include != null && !include.isEmpty()) {
            queryWrapper.select(include);
        }
        
        return getAll(queryWrapper);
    }

    @Override
    public List<StatesVo> getAllStates(Long id) {
        return statesService.getAllByCountryId(id);
    }
}