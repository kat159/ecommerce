package com.ecommerce.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.member.dao.MemberSkuCartDao;
import com.ecommerce.member.dto.MemberSkuCartDto;
import com.ecommerce.member.entity.MemberSkuCartEntity;
import com.ecommerce.member.service.MemberSkuCartService;
import com.ecommerce.member.vo.MemberSkuCartVo;
import org.springframework.stereotype.Service;


@Service
public class MemberSkuCartServiceImpl
        extends CrudServiceImpl<MemberSkuCartDao, MemberSkuCartEntity, MemberSkuCartDto, MemberSkuCartVo>
        implements MemberSkuCartService {
    @Override
    public PageData<MemberSkuCartVo> pageByMemberId(Long id, PaginationDto params) {
        QueryWrapper<MemberSkuCartEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("member_id", id);
        return page(params, queryWrapper);
    }
}