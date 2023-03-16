package com.ecommerce.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.member.dao.ReceivingAddressDao;
import com.ecommerce.member.dto.ReceivingAddressDto;
import com.ecommerce.member.entity.ReceivingAddressEntity;
import com.ecommerce.member.service.ReceivingAddressService;
import com.ecommerce.member.vo.ReceivingAddressVo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReceivingAddressServiceImpl
        extends CrudServiceImpl<ReceivingAddressDao, ReceivingAddressEntity, ReceivingAddressDto, ReceivingAddressVo>
        implements ReceivingAddressService {

    @Override
    public PageData<ReceivingAddressVo> pageByMemberId(Long id, PaginationDto params) {
        QueryWrapper<ReceivingAddressEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("member_id", id);
        queryWrapper.orderByDesc("priority");
        return page(params, queryWrapper);
    }
}