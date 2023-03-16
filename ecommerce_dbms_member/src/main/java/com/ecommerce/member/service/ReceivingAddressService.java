package com.ecommerce.member.service;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.service.CrudService;
import com.ecommerce.member.dto.ReceivingAddressDto;
import com.ecommerce.member.entity.ReceivingAddressEntity;
import com.ecommerce.member.vo.ReceivingAddressVo;

import java.util.List;


public interface ReceivingAddressService extends CrudService<ReceivingAddressEntity, ReceivingAddressDto, ReceivingAddressVo> {

    PageData<ReceivingAddressVo> pageByMemberId(Long id, PaginationDto params);
}