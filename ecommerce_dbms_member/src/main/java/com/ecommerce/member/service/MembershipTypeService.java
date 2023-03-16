package com.ecommerce.member.service;

import com.ecommerce.common.service.CrudService;
import com.ecommerce.member.dto.MembershipTypeDto;
import com.ecommerce.member.entity.MembershipTypeEntity;
import com.ecommerce.member.vo.MembershipTypeVo;


public interface MembershipTypeService extends CrudService<MembershipTypeEntity, MembershipTypeDto, MembershipTypeVo> {

}