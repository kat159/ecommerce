package com.ecommerce.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.member.dao.FavoriteSubjectDao;
import com.ecommerce.member.dto.FavoriteSubjectDto;
import com.ecommerce.member.entity.FavoriteSubjectEntity;
import com.ecommerce.member.service.FavoriteSubjectService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class FavoriteSubjectServiceImpl extends CrudServiceImpl<FavoriteSubjectDao, FavoriteSubjectEntity, FavoriteSubjectDto> implements FavoriteSubjectService {

    @Override
    public QueryWrapper<FavoriteSubjectEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<FavoriteSubjectEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}