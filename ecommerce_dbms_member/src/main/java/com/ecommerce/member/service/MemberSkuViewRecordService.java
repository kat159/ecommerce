package com.ecommerce.member.service;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.service.CrudService;
import com.ecommerce.member.dto.MemberSkuViewRecordDto;
import com.ecommerce.member.entity.MemberSkuViewRecordEntity;
import com.ecommerce.member.vo.MemberSkuViewRecordVo;


public interface MemberSkuViewRecordService extends CrudService<MemberSkuViewRecordEntity, MemberSkuViewRecordDto, MemberSkuViewRecordVo> {

    PageData<MemberSkuViewRecordVo> pageByMemberId(Long id, PaginationDto params);
}