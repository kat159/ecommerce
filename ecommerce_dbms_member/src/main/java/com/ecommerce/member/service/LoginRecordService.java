package com.ecommerce.member.service;

import com.ecommerce.common.service.CrudService;
import com.ecommerce.member.dto.LoginRecordDto;
import com.ecommerce.member.entity.LoginRecordEntity;
import com.ecommerce.member.vo.LoginRecordVo;


public interface LoginRecordService extends CrudService<LoginRecordEntity, LoginRecordDto, LoginRecordVo> {

}