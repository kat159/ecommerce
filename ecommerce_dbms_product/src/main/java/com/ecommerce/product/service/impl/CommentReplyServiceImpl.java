package com.ecommerce.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.product.dao.CommentReplyDao;
import com.ecommerce.product.dto.CommentReplyDto;
import com.ecommerce.product.entity.CommentReplyEntity;
import com.ecommerce.product.service.CommentReplyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class CommentReplyServiceImpl extends CrudServiceImpl<CommentReplyDao, CommentReplyEntity, CommentReplyDto> implements CommentReplyService {

    @Override
    public QueryWrapper<CommentReplyEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<CommentReplyEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}