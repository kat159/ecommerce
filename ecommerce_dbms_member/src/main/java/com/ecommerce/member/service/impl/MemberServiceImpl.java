package com.ecommerce.member.service.impl;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.common.utils.ConvertUtils;
import com.ecommerce.member.dao.MemberDao;
import com.ecommerce.member.dao.MemberSkuCartDao;
import com.ecommerce.member.dao.MemberSkuViewRecordDao;
import com.ecommerce.member.dao.ReceivingAddressDao;
import com.ecommerce.member.dto.MemberDto;
import com.ecommerce.member.dto.MemberSkuCartDto;
import com.ecommerce.member.dto.MemberSkuViewRecordDto;
import com.ecommerce.member.dto.ReceivingAddressDto;
import com.ecommerce.member.entity.MemberEntity;
import com.ecommerce.member.entity.MemberSkuCartEntity;
import com.ecommerce.member.service.MemberService;
import com.ecommerce.member.service.MemberSkuCartService;
import com.ecommerce.member.service.MemberSkuViewRecordService;
import com.ecommerce.member.service.ReceivingAddressService;
import com.ecommerce.member.vo.MemberSkuCartVo;
import com.ecommerce.member.vo.MemberSkuViewRecordVo;
import com.ecommerce.member.vo.MemberVo;
import com.ecommerce.member.vo.ReceivingAddressVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
public class MemberServiceImpl
        extends CrudServiceImpl<MemberDao, MemberEntity, MemberDto, MemberVo>
        implements MemberService {
    @Autowired
    private MemberSkuCartService memberSkuCartService;
    @Autowired
    private MemberSkuCartDao memberSkuCartDao;
    @Autowired
    private ReceivingAddressService receivingAddressService;
    @Autowired
    private ReceivingAddressDao receivingAddressDao;
    @Autowired
    private MemberSkuViewRecordService memberSkuViewRecordService;
    @Autowired
    private MemberSkuViewRecordDao memberSkuViewRecordDao;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public MemberVo login(MemberDto dto, String token) {
        MemberEntity entity = baseDao.getByUsername(dto.getUsername());
        if (entity == null) { // 1. if user not exist, create a new user, ** user's additional info for ecommerce should be updated through update api
            MemberEntity newEntity = new MemberEntity();
            newEntity.setUsername(dto.getUsername());
            newEntity.setNickname(dto.getUsername());
            baseDao.insert(newEntity);
            return ConvertUtils.sourceToTarget(newEntity, MemberVo.class);
        } else { // 2. if user exist, return user info
            return ConvertUtils.sourceToTarget(entity, MemberVo.class);
        }
    }

    @Override
    public MemberVo getByUsername(String username) {
        MemberEntity entity = baseDao.getByUsername(username);
        return ConvertUtils.sourceToTarget(entity, MemberVo.class);
    }

    @Override
    public PageData<MemberSkuCartVo> pageCart(String username, PaginationDto params) {
        MemberEntity entity = baseDao.getByUsername(username);
        if (entity == null) {
            throw new RuntimeException("user not exist, username: " + username + "");
        }
        return memberSkuCartService.pageByMemberId(entity.getId(), params);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addToCart(String username, List<MemberSkuCartDto> cartDtoList) {
        MemberEntity entity = baseDao.getByUsername(username);
        if (entity == null) {
            throw new RuntimeException("user not exist, username: " + username + "");
        }
        for (MemberSkuCartDto cartDto : cartDtoList) {
            if (cartDto.getQuantity() == null || cartDto.getQuantity() <= 0) {
                throw new RuntimeException("quantity to add should be non-null or greater than 0");
            }
            MemberSkuCartEntity cartEntity = memberSkuCartDao.selectByMemberIdAndSkuId(entity.getId(), cartDto.getSkuId());
            if (cartEntity == null) { // new sku
                cartEntity = ConvertUtils.sourceToTarget(cartDto, MemberSkuCartEntity.class);
                cartEntity.setMemberId(entity.getId());
                memberSkuCartDao.insert(cartEntity);
            } else { // existing sku
                cartEntity.setQuantity(cartEntity.getQuantity() + cartDto.getQuantity());
                memberSkuCartDao.updateById(cartEntity);
            }
        }
    }

    @Override
    public PageData<ReceivingAddressVo> pageAddress(String username, PaginationDto params) {
        MemberEntity entity = baseDao.getByUsername(username);
        if (entity == null) {
            throw new RuntimeException("user not exist, username: " + username + "");
        }
        return receivingAddressService.pageByMemberId(entity.getId(), params);
    }

    @Override
    public void addAddress(String username, List<ReceivingAddressDto> dtoList) {
        MemberEntity entity = baseDao.getByUsername(username);
        if (entity == null) {
            throw new RuntimeException("user not exist, username: " + username + "");
        }
        for (ReceivingAddressDto dto : dtoList) {
            dto.setMemberId(entity.getId());
        }
        receivingAddressService.addAll(dtoList);
    }

    @Override
    public PageData<MemberSkuViewRecordVo> pageBrowseHistory(String username, PaginationDto params) {
        MemberEntity entity = baseDao.getByUsername(username);
        if (entity == null) {
            throw new RuntimeException("user not exist, username: " + username + "");
        }
        return memberSkuViewRecordService.pageByMemberId(entity.getId(), params);
    }

    @Override
    public void addToBrowseHistory(String username, List<MemberSkuViewRecordDto> dtoList) {
        MemberEntity entity = baseDao.getByUsername(username);
        if (entity == null) {
            throw new RuntimeException("user not exist, username: " + username + "");
        }
        for (MemberSkuViewRecordDto dto : dtoList) {
            dto.setMemberId(entity.getId());
            Date now = new Date();
            dto.setViewDate(now);
        }
        memberSkuViewRecordService.addAll(dtoList);
    }

}