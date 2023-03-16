package com.ecommerce.member.service;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.service.CrudService;
import com.ecommerce.member.dto.MemberDto;
import com.ecommerce.member.dto.MemberSkuCartDto;
import com.ecommerce.member.dto.MemberSkuViewRecordDto;
import com.ecommerce.member.dto.ReceivingAddressDto;
import com.ecommerce.member.entity.MemberEntity;
import com.ecommerce.member.vo.MemberSkuCartVo;
import com.ecommerce.member.vo.MemberSkuViewRecordVo;
import com.ecommerce.member.vo.MemberVo;
import com.ecommerce.member.vo.ReceivingAddressVo;

import java.util.List;


public interface MemberService extends CrudService<MemberEntity, MemberDto, MemberVo> {

    MemberVo login(MemberDto dto, String token);
    MemberVo getByUsername(String username);

    PageData<MemberSkuCartVo> pageCart(String username, PaginationDto params);

    void addToCart(String username, List<MemberSkuCartDto> cartDtoList);

    PageData<ReceivingAddressVo> pageAddress(String username, PaginationDto params);

    void addAddress(String username, List<ReceivingAddressDto> dtoList);

    PageData<MemberSkuViewRecordVo> pageBrowseHistory(String username, PaginationDto params);

    void addToBrowseHistory(String username, List<MemberSkuViewRecordDto> dtoList);

}