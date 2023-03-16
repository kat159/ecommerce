package com.ecommerce.member.service.impl;

import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.member.dao.LoginRecordDao;
import com.ecommerce.member.dto.LoginRecordDto;
import com.ecommerce.member.entity.LoginRecordEntity;
import com.ecommerce.member.service.LoginRecordService;
import com.ecommerce.member.vo.LoginRecordVo;
import org.springframework.stereotype.Service;


@Service
public class LoginRecordServiceImpl
        extends CrudServiceImpl<LoginRecordDao, LoginRecordEntity, LoginRecordDto, LoginRecordVo>
        implements LoginRecordService {

}