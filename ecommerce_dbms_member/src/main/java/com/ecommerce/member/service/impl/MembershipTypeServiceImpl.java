package com.ecommerce.member.service.impl;

import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.member.dao.MembershipTypeDao;
import com.ecommerce.member.dto.MembershipTypeDto;
import com.ecommerce.member.entity.MembershipTypeEntity;
import com.ecommerce.member.service.MembershipTypeService;
import com.ecommerce.member.vo.MembershipTypeVo;
import org.springframework.stereotype.Service;


@Service
public class MembershipTypeServiceImpl
        extends CrudServiceImpl<MembershipTypeDao, MembershipTypeEntity, MembershipTypeDto, MembershipTypeVo>
        implements MembershipTypeService {

}