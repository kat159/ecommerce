package com.common.country.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.common.country.dao.CitiesDao;
import com.common.country.dto.CitiesDto;
import com.common.country.entity.CitiesEntity;
import com.common.country.service.CitiesService;
import com.common.country.vo.CitiesVo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CitiesServiceImpl
        extends CrudServiceImpl<CitiesDao, CitiesEntity, CitiesDto, CitiesVo>
        implements CitiesService {

    @Override
    public List<CitiesVo> getAllByStateId(Long id) {
        QueryWrapper<CitiesEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state_id", id);
        return getAll(queryWrapper);
    }
}