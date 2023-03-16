package com.ecommerce.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.member.dao.MemberSkuViewRecordDao;
import com.ecommerce.member.dto.MemberSkuViewRecordDto;
import com.ecommerce.member.entity.MemberSkuViewRecordEntity;
import com.ecommerce.member.service.MemberSkuViewRecordService;
import com.ecommerce.member.vo.MemberSkuViewRecordVo;
import org.springframework.stereotype.Service;


@Service
public class MemberSkuViewRecordServiceImpl
        extends CrudServiceImpl<MemberSkuViewRecordDao, MemberSkuViewRecordEntity, MemberSkuViewRecordDto, MemberSkuViewRecordVo>
        implements MemberSkuViewRecordService {

    @Override
    public PageData<MemberSkuViewRecordVo> pageByMemberId(Long id, PaginationDto params) {
        QueryWrapper<MemberSkuViewRecordEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("member_id", id);
        return page(params, queryWrapper);
    }
}