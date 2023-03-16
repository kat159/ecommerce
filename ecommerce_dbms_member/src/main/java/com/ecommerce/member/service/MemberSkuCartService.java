package com.ecommerce.member.service;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.service.CrudService;
import com.ecommerce.member.dto.MemberSkuCartDto;
import com.ecommerce.member.entity.MemberSkuCartEntity;
import com.ecommerce.member.vo.MemberSkuCartVo;


public interface MemberSkuCartService extends CrudService<MemberSkuCartEntity, MemberSkuCartDto, MemberSkuCartVo> {

    PageData<MemberSkuCartVo> pageByMemberId(Long id, PaginationDto params);
}