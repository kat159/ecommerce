package com.common.country.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.common.country.service.CitiesService;
import com.common.country.vo.CitiesVo;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.common.country.dao.StatesDao;
import com.common.country.dto.StatesDto;
import com.common.country.entity.StatesEntity;
import com.common.country.service.StatesService;
import com.common.country.vo.StatesVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StatesServiceImpl
        extends CrudServiceImpl<StatesDao, StatesEntity, StatesDto, StatesVo>
        implements StatesService {

    @Autowired
    private CitiesService citiesService;

    @Override
    public List<StatesVo> getAllByCountryId(Long id) {
        QueryWrapper<StatesEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("country_id", id);
        return getAll(queryWrapper);
    }

    @Override
    public List<CitiesVo> getAllCities(Long id) {
        return citiesService.getAllByStateId(id);
    }
}